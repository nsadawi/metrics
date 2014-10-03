
//package fantail.dc;

import java.util.*;
import java.io.*;

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
        //dc = new ClassAtt();
        //dcValues = dc.characterize(data);
        //for (String key : dcValues.keySet()) {
      	//   System.out.println(key + "," + dcValues.get(key));
        // }

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
        /*     
        dc = new AttributeEntropy();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
         */

        //System.out.println("\nSimpleLandmarkers:");  
        /*    
        dc = new SimpleLandmarkers();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
         */
        
        //System.out.println("\nJ48BasedLandmarker:"); 
        /*
        dc = new J48BasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
         */

        //System.out.println("\nREPTreeBasedLandmarker:"); 
        /*
        dc = new REPTreeBasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
         */

        //System.out.println("\nRandomTreeBasedLandmarker:"); 
        /*
        dc = new RandomTreeBasedLandmarker();
        dcValues = dc.characterize(data);
        for (String key : dcValues.keySet()) {
      	   System.out.println(key + "," + dcValues.get(key));
         }
         */
    }
    
    /**
     * Evaluates Tanimoto coefficient for two bit sets.
     * Code adapted by Noureddin Sadawi from CDK Library
     * @param bitset1 A bitset (such as a fingerprint) for the first molecule
     * @param bitset2 A bitset (such as a fingerprint) for the second molecule
     * @return The Tanimoto coefficient
     */
    public static float calculateTanimotoCoefficient(BitSet bitset1, BitSet bitset2) throws Exception
    {
        float _bitset1_cardinality = bitset1.cardinality();
        float _bitset2_cardinality = bitset2.cardinality();
        if (bitset1.size() != bitset2.size()) {
            throw new Exception("Bisets must have the same bit length");
        }
        BitSet one_and_two = (BitSet)bitset1.clone();
        one_and_two.and(bitset2);
        float _common_bit_count = one_and_two.cardinality(); 
        float _tanimoto_coefficient = _common_bit_count/(_bitset1_cardinality + _bitset2_cardinality - _common_bit_count);
        return _tanimoto_coefficient;
    }
    
    /**
     * Creates a BitSet from a binary string Tanimoto coefficient for two bit sets.
     * @param bits A binary string
     * @return The Generated BitSet
     */
    public static BitSet createBitSet(String bits)
    {
      int len = bits.length();
      BitSet bs = new BitSet(len);
      for (int i = 0; i < len; i++)
      {
        bs.set(len - i - 1, bits.charAt(i) == '1');
      }
      return bs;
    }

/**
 * Receives a tsv file and returns a hashtable of target id and the value of CS
 * Skips the first line as it's the column names!
 * File contents are of the form: tid	cs
 *
 * @param  inFile  a fully qualified filename of the input tsv file 
 * @return pairs hashtable of (target id, the value of CS)
 */  
  public static Hashtable getCS(String inFile) throws IOException {               
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        String s = br.readLine(); // skip 1st line        

        Hashtable pairs = new Hashtable();
        
        String line;
	while ((line = br.readLine()) != null) {
	    // split the line.
	    String[] tokens= line.split("\t");
	    pairs.put(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));	    	    	    	    
	}

       //Close the streams
        br.close();
        return pairs;     
  }
      
    
 /**
 * Receives a csv file and returns a list of FP values from a column range
 * Skips the first line as it's the column names!
 *
 * @param  inFile  a fully qualified filename of the input tsv file 
 * @param  startFP  start of FP columns
 * @param  endFP  start of FP columns
 * @return      fpList a list of FP's of all compounds 
 */  
  public static List<String> getAllFingerPrints(String inFile, int startFP, int endFP) throws IOException {               
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        String s = br.readLine(); // skip 1st line        
        //s = br.readLine(); 
        //String[] headerNames = s.split(",");
	//System.out.println(headerNames.length);
        List<String> fpList = new ArrayList<String>();        
        
        String line;
	while ((line = br.readLine()) != null) {
	    // split the line.
	    String[] tokens= line.split(",");
	    String FPs = "";
	    //System.out.println(tokens.length);
	    for(int i = startFP; i < (endFP - startFP); i++){
	       FPs = FPs + tokens[i];
	       //System.out.print(tokens[i]);
	    }
	    //String fp = tokens[fpColumnIndex]; 
            //System.out.println(FPs);		      	 
	    fpList.add(FPs);	    	    	    	    
	}		        			                    
       //Close the streams
        br.close();
        return fpList;     
  }

    public static void main(String args[]) throws Exception {

        //String datasetPath = "/home/likewise-open/ACADEMIC/csstnns/mygit/metrics/graphs/eve_ds/TS3-Labeled.csv";
	if (args.length != 4) {
            System.err.println("Usage: java DatasetMetaFeatures <Dataset> <Start FP Column> <End FP Column> <TargetID>");
            System.exit(1); 
        }
        String datasetPath = args[0];
        int startFP  = Integer.parseInt(args[1]);
        int endFP    = Integer.parseInt(args[2]);
        int targetID = Integer.parseInt(args[3]);
        DataSource source = new DataSource(datasetPath);
        Instances data = source.getDataSet();
        if (data.classIndex() == -1) {
            data.setClassIndex(data.numAttributes() - 1);
        }
        //System.err.println(datasetPath);
        datasetCharacteristics(data);
        try{
            /***** compute generic diversity index *******/
            List<String> fpList = getAllFingerPrints(datasetPath, startFP, endFP);     
            //int targetID = getTargetID("subdatasets/csv/105.tsv", 0);
            //Hashtable TID_CS = getCS("TID_CS_Table.txt");
            // get value at key targetID
            //System.out.println("Value at key "+targetID+" is:"+TID_CS.get(targetID)); 
      
            //Now compute diversity from willett's paper
            int nc = fpList.size();
            // get the natural logarithm for nc
            //System.out.println("Math.log(" + nc + ")=" + Math.log(nc));
            
            double sum = 0;
            for(int i = 0; i < nc ; i++){
    	      String s = fpList.get(0);
    	      //System.out.println(fpList.size());    	    
    	      BitSet bits1 = createBitSet(s);
    	      
    	      //fpList.remove(0);
    	      for(String fp : fpList)
  	      {  	
  	         BitSet bits2 = createBitSet(fp);
                 double t = calculateTanimotoCoefficient(bits1, bits2);
                 sum = sum + t;
                 //System.out.println(t);
    	      } 
    	      
    	    }   
    	    System.out.println("Generic_Diversity_Index," +sum/(nc*nc)); 
    	    
    	    /***** compute another diversity index *******/
    	    Hashtable TID_CS = getCS("TID_CS_Table.txt");
    	    double sim = Double.MAX_VALUE;
            double tt = 0;
            List<Double> natList = new ArrayList<Double>();
            for(int i = 0; i < nc ; i++){
    	      String ss = fpList.get(i);
    	      //System.out.println(fpList.size());    	    
    	      BitSet bits11 = createBitSet(ss);
    	      //fpList.remove(0);
    	      for(String fp : fpList)
  	      {  	
  	         BitSet bits22 = createBitSet(fp);
                 tt = calculateTanimotoCoefficient(bits11, bits22);
                 if(tt < sim)
                     sim = tt;
                 //sum = sum + t;
                 //System.out.println(t);
    	      } 
    	      //System.out.println(tt);    	          	      
    	      natList.add(sim);
    	      sim = Double.MAX_VALUE;
    	    }   
    	    //System.out.println(sum/(n*n));	 
    	    //System.out.println(n);	    
    	    //System.out.println(nat.size());
    	    double natSum = 0;
    	    for(double t : natList)
  	      { natSum = natSum + t; } 
  	    
  	    double nat = natSum/natList.size();
  	    //System.out.println(nat); 
  	    
  	    double sdi = (1 - nat) / (0.8047 - 0.065 * Math.log(nc));//math.log computes the natural log 
  	    //System.out.println("SDI = "+ sdi); 
  	    int cs = (int)TID_CS.get(targetID);
  	    //System.out.println("cs = "+ cs + " nc = "+nc); 
  	    double term = (double)nc/((double)cs*(double)cs); //System.out.println("term = "+ term);  //System.out.println("term = "+ (1251.0/371.0));  
  	    double cr = -(Math.log10(term));//math.log computes the natural log 
    	    //System.out.println("CR = "+ cr);  
    	    double ediU = (Math.sqrt(2)/2)*(sdi+cr);
    	    //System.out.println("edi unscaled = "+ ediU);  
    	    double edi = ((Math.tanh(ediU/3) + 1)/2) * 100;
    	    System.out.println("Explicit_Diversity_Index,"+ edi); 

        } catch (Exception e){System.out.println("An error occurred!");}
    }
}

