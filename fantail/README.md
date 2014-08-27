- I have merged the files from TS3 (file Dec2010TS3cherrypick.csv is not available on the G Drive):
 JHCCL_DHFR_CS_63_12_61_20120531103405.csv
 JHCCL_DHFR_CS_63_2_10_20110421150005.csv
 JHCCL_DHFR_CS_63_3_32_20111209133124.csv
 JHCCL_DHFR_CS_63_7_45_20120417093418.csv
 JHCCL_DHFR_MS_63_1_15_20110414203535.csv


- The labeled Dataset file is TS3-Labeled.csv (it only contains 4 labels ... no PossiblyToxic!)
- The target is DHFR (Strains: MCherry = Human Strain (Hs), Sapphire = Plasmodium vivax (Pv), Venus = Plasmodium falciparum drug resistant (PfR) )
- CHEMBL says DHFR is Single Protein

- I have run the Naive Bayes, SVM, Decision Trees and Random Forests classification algorithms on TS3-Labeled.csv with 10 fold Cross Validation and the results are in model_results.csv

Last update Wed 27 Aug 2014 by NS


