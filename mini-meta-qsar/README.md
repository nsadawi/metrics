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

update on 03/10/14 by NS
- Now the library computes less descriptors for experimental purposes
- The TID_CS_Table.txt is required to look up a value needed for computing one diversity index (file provided by Dundee group)
- We have to add more for regression datasets (currently the lib assumes classification datasets)
- On my Machine, it took > 2.5 minutes to run on the sample data_50.csv file!
- We need to pass 4 parameters to the java code:
* The path/to/dataset/name
* The index of the first FP column
* The index of the last FP column (assuming all mid-columns are FP's)
* The target ID



