package com.demo;

import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import net.opengis.gml.v_2_1_2.TestType;

public class XjcTest {

    @Before
    public void setup(){
//        https://stackoverflow.com/questions/51617382/changing-the-method-name-of-a-xjc-generated-class
//        https://stackoverflow.com/questions/24519449/unable-to-marshal-type-as-an-element-because-it-is-missing-an-xmlrootelement-an
//        https://stackoverflow.com/questions/819720/no-xmlrootelement-generated-by-jaxb/2172942#2172942
//        https://codenotfound.com/jaxb-marshal-element-missing-xmlrootelement-annotation.html
//        https://javaee.github.io/jaxb-v2/doc/user-guide/ch03.html
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testClasses() throws Exception{
        JAXBContext jc = JAXBContext.newInstance( "net.opengis.gml.v_2_1_2" );
        TestType testType = new TestType();
        testType.setId(1);
        testType.setDescription("description");
        testType.setName("name");

        // create an element for marshalling
        QName qName = new QName("com.codenotfound.jaxb.model", "testEl");
        JAXBElement<TestType> root = new JAXBElement<TestType>(qName, TestType.class, testType);


        // Create a Marshaller with the createMarshaller method. The Marshaller class has overloaded marshal
        // methods to marshal (that is, convert a Java object to XML data) into SAX2 events, a Document Object
        // Model (DOM) structure, an OutputStream, a javax.xml.transform.Result, or a java.io.Writer object.
        Marshaller m = jc.createMarshaller();
        m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

        //Marshal the  poElement object to an XML document with the marshal method of the class Marshaller.
        //The poElement object is marshalled to an OutputStream.
        m.marshal( root, System.out);
    }
}
