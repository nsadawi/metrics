#function to retrieve dataset features from R:
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
  # start index of FP columns .. 0 based
  startFP = 9
  # end index of FP columns .. 0 based
  endFP = 1035
  # Target ID
  TID = 150
  # prepare the command by concatenating things
  # ot should look like: java DatasetMetaFeatures ds.csv > tmp
  command=paste("java",exec, dataset,startFP,endFP,TID,">",tmpfile)
  system(command) # execute the command
  # read the results from the tmp file
  features = readChar(tmpfile, file.info(tmpfile)$size)
  # return to the original working directory
  setwd(wd)
  # return the results
  features
}
