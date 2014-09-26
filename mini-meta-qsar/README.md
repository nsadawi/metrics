This dir contains info on how to compute descriptors for datasets and targets
- currently only datasets!

- The dataset-metrics.csv file contains the list of dataset metrics and their meaning
- The DatasetMetaFeatures.java file has the code to compute the dataset features
- Remember to download the java packages in the java-pks/ dir
- Add them to your classpath
- You should manually compile the DatasetMetaFeatures.java file (or I can add code to compile it from R)
- Then use the R function at the bottom to execute it from within R
- Needless to say you can modify code as you wish
- Any questions, just ask!

last update 26/09/14 by NS


function to retrieve dataset features from R:
dataset.features<-function()
{
  # java exec name
  exec="DatasetMetaFeatures" 
  # exact path to dataset
  dataset="~/mygit/metrics/graphs/eve_ds/TS3-Labeled.csv"
  # temp file to store results in
  tmpfile=tempfile()
  # we change the working dir to where the java exec is!
  wd <- getwd()
  nwd = "~/test/"
  setwd(nwd)
  # prepare the command by concatenating things
  # ot should look like: java DatasetMetaFeatures ds.csv > tmp
  command=paste("java",exec, dataset ,">",tmpfile)
  system(command) # execute the command
  # read the results from the tmp file
  features = readChar(tmpfile, file.info(tmpfile)$size)
  # return to the original working directory
  setwd(wd)
  # return the results
  features
}
