package XML;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml {

	private static void guardarXML(String nombreGanador, String tipoVecinoGanador) {

		File archivo = new File("src/xml/prueba.xml");
		
		//Hacer un array para que no se borre lo que ya tenemos y nos guarde a los jugadores
		
		
		//Para la fecha
//		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
//		ganador = ganador + " " + dtf2.format(LocalDateTime.now());
		
		try {
			//crear estructura del xml
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// elemento raiz: fichero
			Document doc = docBuilder.newDocument();
			Element elemento = doc.createElement("fichero");
			doc.appendChild(elemento);

			Element equipo = doc.createElement("equipo");
			elemento.appendChild(equipo);

			// atributo para el nodo equipo
//			Attr attr = doc.createAttribute("id");
//			attr.setValue(String.valueOf(idAt));
//			
//			equipo.setAttributeNode(attr);

			//nombre del Vecino
			Element nombreVecino = doc.createElement("nombreVecino");
			nombreVecino.appendChild(doc.createTextNode(nombreGanador));
			equipo.appendChild(nombreVecino);

			// tipo Vecino
			Element tipoVecino = doc.createElement("tipoVecino");
			tipoVecino.appendChild(doc.createTextNode(tipoVecinoGanador));
			equipo.appendChild(tipoVecino);

			// escribimos el contenido en un archivo .xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(archivo);

			transformer.transform(source, result);

			System.out.println("Fichero guardado");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	} 



	public static void leerXML() {
		File archivo = new File("src/xml/prueba.xml");
		try {
			//cargar el fichero
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();


			//recorrer el fichero XML
			NodeList nList = document.getElementsByTagName("equipo");
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				//comprobamos si el elemento tiene elemento
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					//escogemos un elemento del xml
					Element eElement = (Element) nNode;

					//leemos el atributo
					String numEquipo=eElement.getAttribute("id");

					//leemos los elementos
					String nomEquipo = eElement.getElementsByTagName("nombreVecino").item(0).getTextContent();
					String tEquipo = eElement.getElementsByTagName("tipoVecino").item(0).getTextContent();

					//mostramos los elementos por consola
					System.out.println("N�mero de equipo: " + numEquipo);
					System.out.println("Nombre de vecino: " + nomEquipo);
					System.out.println("Tipo de vecino: " + tEquipo);
					System.out.println();
				}
			}

		}catch (Exception e) {
			System.out.println("Error lectura de fichero");
		}
	}
}

