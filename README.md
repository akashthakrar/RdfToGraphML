This project converts  rdf files to .graphml format. It uses apache jena to read the rdf file. Then model created is converted 
to tinkerpop blueprint graph by extracting subject, predicate and object. That graph is exported as graphml file.

To use this project, download it and open it with netbeans.
Project converts RDF data files to graphML format and gives output in .graphML file.

Following is the list of dependencies that needs to be included to project.

1)  jena-core-2.13.0.jar
2)  slf4j-api-1.7.6.jar
3)  log4j-1.2.17.jar
4)  slf4j-log4j12-1-7-6.jar
5)  xercesImpl-2.11.0.jar
6)  xml-apis-1.4.01.jar
7)  jena-iti-1.1.2.jar
8)  jena-arq-2.13.0.jar
9)  blueprints-core-2.4.0.jar
10) gremlin-java.2.4.0.jar

Sources for dependencies :

http://archive.apache.org/dist/jena/binaries/  
( Above mentioned 1 to 8 dependencies will be available from this link. )
( From the link download apache-jena-2.13.0.zip file, extract zip to get all jars )
                                               
http://www.java2s.com/Code/Jar/b/Downloadblueprintscore240jar.htm
( 9th dependency can be downloaded from this link blueprints-core-2.4.0.jar.zip )
( Extract zip to get the jar )

http://www.java2s.com/Code/Jar/g/Downloadgremlinjava240jar.htm
( 10th dependency can be downloaded from this link. )
( Extract zip to get the jar )

Need to give full path to the source file (.ttl / .nt / xml (.rdf file) )
Output will be available in main project folder with name result.graphml .

-> from_nt.graphml contains output of .nt file downloaded from https://www.wikidata.org/wiki/Special:EntityData/Q46352885.nt

-> from_ttl.graphml contains output of .ttl file downloaded from https://www.wikidata.org/wiki/Special:EntityData/Q46352885.ttl

-> from_rdf.graphml contains output of .rdf (xml) file downloaded from https://www.wikidata.org/wiki/Special:EntityData/Q46352885.rdf
