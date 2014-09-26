By NS:
- This is an R package so it will be straight-forward to use
- It computes various descriptors and it has many similarity measures
- It comes with 35 datasets of precomputed descriptors for 20 amino acids
- The graphml file (display and edit with yEd) lists everything and gives brief dexplanation!


======================== From ProtR Documentation ===========================
The protr package focus on offering a unique and comprehensive toolkit for protein sequence descriptor calculation and similarity computation. 

The descriptors included in the protr package are extensively utilized in Bioinformatics and Chemogenomics research. 

The qualitative descriptors listed in protr include:
  # Amino Acid Composition (Amino Acid Composition/Dipeptide Composition/Tripeptide Composition) descriptor
  # Autocorrelation (Normalized Moreau-Broto Autocorrelation/Moran Autocorrelation/Geary Autocorrelation) descriptor
  # CTD (Composition/Transition/Distribution) descriptor
  # Conjoint Traid descriptor
  # Quasi-sequence Order (Sequence Order Coupling Number/Quasi-sequence Order Descriptors) descriptor
  # Pseudo Amino Acid Composition (Pseudo Amino Acid Composition/Amphiphilic Pseudo Amino Acid Composition) descriptor
  
The quantitative descriptors, for Proteochemometric (PCM) Modeling, includes:
  # the Generalized Scales-Based Descriptors derived by Principal Components Analysis
  # Generalized Scales-Based Descriptors derived by AA-Properties (AAindex)
  # Generalized Scales-Based Descriptors derived by 20+ classes of 2D and 3D Molecular Descriptors (Topological, WHIM, VHSE, etc.)
  # Generalized Scales-Based Descriptors derived by Factor Analysis
  # Generalized Scales-Based Descriptors derived by Multidimensional Scaling
  # Generalized BLOSUM/PAM Matrix-Derived Descriptors
  

  
The protr package also integrates the functionality of parallellized similarity computation derived by protein sequence alignment and Gene Ontology (GO) semantic similarity measures between a list of protein sequences / GO terms / Entrez Gene IDs. 

ProtrWeb, the web service built on protr, is located at: http://cbdd.csu.edu.cn:8080/protrweb/ . 

The protr package is developed by Computational Biology and Drug Design (CBDD) Group, Central South University.