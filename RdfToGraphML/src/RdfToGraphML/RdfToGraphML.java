/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RdfToGraphML;


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;



import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashSet;


/**
 *
 * @author Akash Thakrar
 */
public class RdfToGraphML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
            Graph graph = new TinkerGraph(); //tinkerpop graph to create graphml
            HashSet vertices = new HashSet(); // for storing nodes
            String inputFileName = args[0]; //get file name with full path
            //Model model = RDFDataMgr.loadModel(inputFileName);  //uncomment this to use RDFDataMgr.loadModel method
            Model model = ModelFactory.createDefaultModel().read(inputFileName); //jena model from rdf file

            StmtIterator s = model.listStatements(); //iterator to iterate through rdf file
            Statement st;

            // Subject vertex
            Resource sub;
            Vertex vsub;

            // Predicate vertex
            Property pre;
            Edge epre;

            // Object vertex
            RDFNode obj;
            Vertex vobj;

            /*loop travers through each statement,
            adds the subject and object to hashset
            if not available and creates Vertex
            class objects for subject and object.
            Then reads predicate and creates edge
            between subject and object vertex.*/
            
            while(s.hasNext()){
                st = s.next();

                sub = st.getSubject();
                pre = st.getPredicate();
                obj = st.getObject();

                //subject
                if(!vertices.contains(sub)){
                    vsub = graph.addVertex(sub);
                    vertices.add(sub);
                }
                else{
                    vsub = graph.getVertex(sub.toString());
                }

                //object
                if(!vertices.contains(obj)){
                    vobj = graph.addVertex(obj);
                    vertices.add(obj);
                }
                else{
                    vobj = graph.getVertex(obj.toString());
                }

                //predicate
                epre = graph.addEdge(null,vsub,vobj,pre.toString());
            }

            // OutputStream object which will give output in project folder.
            OutputStream out = new FileOutputStream("result.graphml");

            //writes graphml file from the given blueprint graph
            GraphMLWriter.outputGraph(graph, out);
        }

}
