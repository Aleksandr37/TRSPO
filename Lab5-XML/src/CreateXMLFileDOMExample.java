import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateXMLFileDOMExample {

    private static final String FILENAME = "staff.xml";

    public static void main(String[] args) {
        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();

            // Корневой элемент
            Element company = document.createElement("company");
            document.appendChild(company);

            // Элемент типа staff
            Element staff = document.createElement("staff");
            company.appendChild(staff);

            // Определяем идентификатор сотрудника
            Attr id = document.createAttribute("id");
            id.setTextContent("1");
            staff.setAttributeNode(id);


            // Определяем имя
            Element firstname = document.createElement("firstname");
            firstname.setTextContent("Александр");
            staff.appendChild(firstname);

            // Определяем фамилию
            Element lastname = document.createElement("lastname");
            lastname.setTextContent("Блажевский");
            staff.appendChild(lastname);

            // Определяем никнейм
            Element nickname = document.createElement("nickname");
            nickname.setTextContent("sany");
            staff.appendChild(nickname);

            // Определяем зарплату
            Element salary = document.createElement("salary");
            salary.setTextContent("10000");
            staff.appendChild(salary);

            // Сохранить текстовое представление XML документа в файл
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(
                    new File(System.getProperty("user.dir")
                            + File.separator + FILENAME));

            transformer.transform(source, result);

            System.out.println("Документ сохранен!");

        } catch (ParserConfigurationException
                | TransformerConfigurationException ex) {
            Logger.getLogger(CreateXMLFileDOMExample.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CreateXMLFileDOMExample.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
