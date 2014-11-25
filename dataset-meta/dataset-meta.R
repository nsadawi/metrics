# ##########################################################################################
# to install the required packages:
# install.packages(c( 'infotheo','benchmark','entropy'))
#
# how to use functions from R:
# inside R, just run> source('/path/to/dataset-meta.R')
# ##########################################################################################

#computes number of columns
n_col <- function(x) {
    dim(x)[2]
}

#computes number of rows
n_row <- function(x) {
    dim(x)[1]
}

#returns class index .. assuming it's the last column
get_class_indx <- function(data) {
    length(data)
}

#returns class data
get_class_data <- function(data) {
    data[get_class_indx(data)]
}

#returns attriute data
get_att_data <- function(data) {
    class_index <- get_class_indx(data)
    data[-class_index]
}


#computes class entropy
#if data is numerical, discretize it!
get_discretized_class_entropy <- function(data) {
    class_data <- get_class_data(data)
    class_data <- class_data[,1]
    ## added by Noureddin Sadawi
    #if class data is numerical, discretize it!
    if(is.numeric(class_data)) {
        class_data <- infotheo::discretize(class_data, disc="equalwidth")
    }    
   infotheo::entropy(class_data)    
}

#computes normalized entropy of a certain column
#if data is numerical, discretize it!
get_normalized_entropy <- function(column) {
    column <- column[,1]
    if(is.numeric(column)) {
        column <- infotheo::discretize(column, disc="equalwidth")
        n <- round(sqrt(dim(column)[1]))     # -- number of bins = square root of number of samples --
    } else {
        n <- length(levels(as.factor(column)))
    }
    infotheo::entropy(column) / log(n)
}

#computes normalized class entropy
get_normalized_class_entropy <- function(data) {
    get_normalized_entropy(get_class_data(data))
}

#computes entropy of a certain columns
#if data is numerical, discretize it!
get_entropy <- function(column, method="ML") {
    column <- column[,1]
    #if data is numerical, discretize it!
    if(is.numeric(column)) {
        column <- infotheo::discretize(column, disc="equalwidth")
    }
    infotheo::entropy(column)
}


#averages result of applying function f to data columns
get_avg <- function(data, f) {
    att_data <- get_att_data(data)
    avg <- 0.0
    for(i in 1:n_col(att_data)) {
        avg <- avg + f(att_data[i])
    }
    avg / n_col(att_data)
}


# computes attributes entropy
get_attribute_entropy <- function(data) {
    get_avg(data, get_entropy)
}

# computes normalized entropy for a certain column
get_normalized_entropy <- function(column) {
    column <- column[,1]
    if(is.numeric(column)) {
        column <- infotheo::discretize(column, disc="equalwidth")
        n <- round(sqrt(dim(column)[1]))     # -- number of bins = square root of number of samples --
    } else {
        n <- length(levels(as.factor(column)))
    }
    infotheo::entropy(column) / log(n)
}

# computes normalized attributes entropy
get_normalized_attribute_entropy <- function(data) {
    get_avg(data, get_normalized_entropy)
}

#averages result of applying function f to data columns
# function f requires the labels!
get_avg_with_labels <- function(data, f) {
    att_data <- get_att_data(data)
    labels <- get_class_data(data)
    tmp_labels <- labels[,1]
    #if class data is numerical, discretize it!
    if(is.numeric(tmp_labels))
      labels <- infotheo::discretize(labels, disc="equalwidth")
    
    avg <- 0.0
    for(i in 1:n_col(att_data)) {
        # here we're sending labels NOT tmp_labels 
        # because the function f does labels <- labels[,1]
        avg <- avg + f(att_data[i], labels)
    }
    avg / n_col(att_data)
}

#computes mutual information for a certain column
get_mutual_information_column <- function(column, labels) {
    column <- column[,1]
    labels <- labels[,1]
    if(is.numeric(column)) {
        column <- infotheo::discretize(column, disc="equalwidth")
    }
    infotheo::mutinformation(column, labels)
}


#computes mutual information
get_mutual_information <- function(data) {
    get_avg_with_labels(data, get_mutual_information_column)
}


# computes entropy of class
# if class data is numerical, discretizes it first!
get_discretized_class_entropy <- function(data) {
    class_data <- get_class_data(data)
    class_data <- class_data[,1]
    ## added by Noureddin Sadawi
    #if class data is numerical, discretize it!
    if(is.numeric(class_data)) {
        class_data <- infotheo::discretize(class_data, disc="equalwidth")
    }    
   infotheo::entropy(class_data)    
}

# computes equivalent number of attributes
get_equivalent_number_of_attributes <- function(data) {
    get_discretized_class_entropy(data) / get_mutual_information(data)
}

# computes noise to signal ratio
get_noise_signal_ratio <- function(data) {
    (get_attribute_entropy(data) - get_mutual_information(data)) / get_mutual_information(data)
}

#computes multiinformation
get_multiinformation <- function(data){
   infotheo::multiinformation(infotheo::discretize(data,disc="equalwidth"), method="emp")
}

read_data <- function(filename) {
    data<-read.csv(filename, header=TRUE, sep=',')    
}


compute_grouped_meta_features <- function(data) {
    
   
    
    inftheo <- numeric(0)

    inftheo['class_entropy'] <- get_discretized_class_entropy(data)#
    
}
