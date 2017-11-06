package persistencebuild.builder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UpDateXML {

	public static void main(String argv[]) {

		try {
			String filepath = "D:" + File.separator + "persistence.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			String nomeClasse = "br.gov.prodemge.prodigio.meucurso.entidades.livro.LivroVO";
			// Get the root element
			Node persistenceNode = doc.getFirstChild();

			// Get the staff element by tag name directly

			final NodeList childpersistenceNodes = persistenceNode.getChildNodes();
			Node persistenceUnitNode = null;

			for (int i = 0; i < childpersistenceNodes.getLength(); i++) {
				if (childpersistenceNodes.item(i).getNodeName().equals("persistence-unit")) {
					persistenceUnitNode = childpersistenceNodes.item(i);
				}
			}

			final NodeList childNodes = persistenceUnitNode.getChildNodes();

			final Map<String, Node> tagClass = preencheMapDeTagClass(childNodes);

			final boolean remover = true;
			if (remover) {
				if (tagClass.containsKey(nomeClasse)) {
					removeTagClass(nomeClasse, tagClass);
				}
			} else {
				if (!tagClass.containsKey(nomeClasse)) {
					addTagClass(nomeClasse, persistenceUnitNode);
				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	private static void addTagClass(String nomeClasse, Node persistenceUnitNode) {
		final NodeList childNodes = persistenceUnitNode.getChildNodes();
		Node itemUtimo = recuperaUltimaTagClass(childNodes);
		Document doc = 		persistenceUnitNode.getOwnerDocument();
		Element classe = doc .createElement("class");
		classe.appendChild(doc.createTextNode(nomeClasse));
		persistenceUnitNode.insertBefore(classe, itemUtimo);
	}

	private static void removeTagClass(String nomeClasse, final Map<String, Node> tagClass) {
		final Node node = tagClass.get(nomeClasse);
		final Node parentNode = node.getParentNode();
		parentNode.removeChild(node);
	}

	private static Map<String, Node> preencheMapDeTagClass(final NodeList childNodes) {
		Map<String, Node> classesNode = new HashMap<String, Node>();
		Node item = null;
		for (int i = 0; i < childNodes.getLength(); i++) {
			item = childNodes.item(i);
			if (item.getNodeName().equals("class")) {
				String textContent = item.getTextContent();
				classesNode.put(textContent, item);
			}
		}
		return classesNode;
	}

	private static Node recuperaUltimaTagClass(final NodeList childNodes) {
		Node itemUtimo = null;
		Node item = null;
		for (int i = 0; i < childNodes.getLength(); i++) {
			item = childNodes.item(i);
			if (item.getNodeName().equals("class")) {
				itemUtimo = item;
			}
		}
		return itemUtimo;
	}
}