
//package fantail.dc;

import java.util.Map;

import fantail.dc.Characterizer;
//import fantail.dc.DCValue;
import fantail.dc.landmarking.*;
import fantail.dc.statistical.*;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;
//import weka.core.converters.ConverterUtils.*;
//import java.io.*;

public class DatasetMetaFeatures {

    public static void datasetCharacteristics(Instances data) {
    	//System.out.println("Statistical:");
        Characterizer dc = new Statistical();
        Map<String, Double> dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
        	   System.out.println(key + "," + dcValues.get(key));
        }
        	        		       
        //System.out.println("\nAttributeCount:");
        dc = new AttributeCount();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
     	   System.out.println(key + "," + dcValues.get(key));
        }
        
        //System.out.println("\nAttributeType:");       
        dc = new AttributeType();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nClassAtt:");       
        dc = new ClassAtt();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nDefaultAccuracy:");       
        dc = new DefaultAccuracy();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
        
        //System.out.println("\nIncompleteInstanceCount:");       
        dc = new IncompleteInstanceCount();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nInstanceCount:");       
        dc = new InstanceCount();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nMissingValues:");       
        dc = new MissingValues();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nNominalAttDistinctValues:");       
        dc = new NominalAttDistinctValues();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nAttributeEntropy:");      
        dc = new AttributeEntropy();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nSimpleLandmarkers:");      
        dc = new SimpleLandmarkers();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
        
        //System.out.println("\nJ48BasedLandmarker:"); 
        dc = new J48BasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nREPTreeBasedLandmarker:"); 
        dc = new REPTreeBasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }

        //System.out.println("\nRandomTreeBasedLandmarker:"); 
        dc = new RandomTreeBasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
    }

    public static void main(String args[]) throws Exception {

        //String datasetPath = "/home/likewise-open/ACADEMIC/csstnns/mygit/metrics/graphs/eve_ds/TS3-Labeled.csv";
	if (args.length != 1) {
            System.err.println("Usage: java DatasetMetaFeatures <Dataset>");
            System.exit(1); 
        }
        String datasetPath = args[0];
        DataSource source = new DataSource(datasetPath);
        Instances data = source.getDataSet();
        if (data.classIndex() == -1) {
            data.setClassIndex(data.numAttributes() - 1);
        }
        //System.err.println(datasetPath);
        datasetCharacteristics(data);
    }
}

