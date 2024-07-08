

package com.example.hrms.mernis;
//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 9.0.0.0
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: 576BC6EDF2717A518E1B10AC72E4F0ADA1AD0BB6DBBECBC6122D56446221D6C6C9F5FC31EAA653DB8574F1E24F81B252189D274640B51CB856A52A3AEFB58BCD
//------------------------------------------------------------------------
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.*;
import java.io.InputStream;

enum SVMSoapVersion {
    v1_0,
    v1_1,
    v1_2
}

interface SVMISerializableObject
{
    void loadWithXml(org.w3c.dom.Element __node, SVMRequestResultHandler __handler);
    void serialize(org.w3c.dom.Element __node,SVMRequestResultHandler __handler);
}

interface SVMIReferenceObject
{
}

public class SVMRequestResultHandler
{
    private SVMSoapVersion _version=SVMSoapVersion.v1_1;
    
    public SVMSoapVersion getVersion(){
        return _version;
    }
    private String soapNS = "";
    private HashMap<Object, String> reverseReferencesTable =new HashMap<Object, String>();
    private HashMap<String, Object> referencesTable = new HashMap<String, Object>();
    private org.w3c.dom.Element body=null;
    private org.w3c.dom.Element header=null;

    private org.w3c.dom.Element outputBody=null;
    private org.w3c.dom.Element outputHeader=null;
    
    private HashMap<String, String> namespaces = new HashMap<String, String>();

    private static SVMDateTimeParser dateTimeConverter=new SVMStandardDateTimeParser();
    private static HashMap< java.lang.String,java.lang.Class> classNames = new HashMap< java.lang.String, java.lang.Class>();
    private static HashMap< java.lang.Class,java.lang.String> reverseClassNames = new HashMap< java.lang.Class, java.lang.String>();
    private static HashMap< java.lang.String,java.lang.String> elementNames = new HashMap< java.lang.String, java.lang.String>();

    public SVMRequestResultHandler(SVMSoapVersion version)
    {
        _version=version;
    }



    public String getSoapNamespace()
    {
        return soapNS;
    }

    public org.w3c.dom.Element getBody() {
        return body;
    }

    public void setBody(org.w3c.dom.Element body) {
        this.body = body;
    }

    public org.w3c.dom.Element getHeader() {
        return header;
    }

    public void setHeader(org.w3c.dom.Element header) {
        this.header = header;
    }

    public org.w3c.dom.Element getOutputBody() {
        return outputBody;
    }

    public void setOutputBody(org.w3c.dom.Element outputBody) {
        this.outputBody = outputBody;
    }

    public org.w3c.dom.Element getOutputHeader() {
        return outputHeader;
    }

    public void setOutputHeader(org.w3c.dom.Element outputHeader) {
        this.outputHeader = outputHeader;
    }

    public static void setDateTimeParser(SVMDateTimeParser converter)
    {
        if(converter==null)
        {
            converter = new SVMStandardDateTimeParser();
        }
        dateTimeConverter=converter;
    }

    public static SVMDateTimeParser getDateTimeParser()
    {
        return dateTimeConverter;
    }

    public org.w3c.dom.Attr addAttribute(org.w3c.dom.Element element, String namespace,String name, String value)
    {
        String prefix=ensureNamespace(namespace,element.getOwnerDocument(),null);
        String attrName=name;
        if(!SVMHelper.isEmpty(prefix))
        {
            attrName=prefix+":"+name;
        }
        org.w3c.dom.Attr attr=element.getOwnerDocument().createAttributeNS(namespace,attrName);
        attr.setValue(value);
        element.setAttributeNodeNS(attr);
        return attr;
    }

    public org.w3c.dom.Document createEnvelopeXml() throws ParserConfigurationException
    {
        soapNS = _version == SVMSoapVersion.v1_2 ? "http://www.w3.org/2003/05/soap-envelope" : "http://schemas.xmlsoap.org/soap/envelope/";
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document xml =docBuilder.newDocument();
       
        org.w3c.dom.Element envelope=xml.createElementNS(soapNS,"soap:Envelope");
        header=xml.createElementNS(soapNS,"soap:Header");
        body =xml.createElementNS(soapNS,"soap:Body");
        xml.appendChild(envelope);
        envelope.appendChild(header);
        envelope.appendChild(body);

        ensureNamespace(soapNS,xml,"soap");
        ensureNamespace(SVMHelper.MS_SERIALIZATION_NS,xml,"ms");
        ensureNamespace(SVMHelper.XSI,xml,"xsi");
        return xml;
    }
    
    protected void finishEnvelopeXml(org.w3c.dom.Document doc) {
            
    }

    public void addWSAddressingHeaders(String action, String replyTo,String to,List< String>  referenceParameters)
    {
        org.w3c.dom.Document xml=header.getOwnerDocument();
        org.w3c.dom.Element wsaddressingElement=writeElement("http://www.w3.org/2005/08/addressing","Action",xml );
        header.appendChild(wsaddressingElement);
        wsaddressingElement.setTextContent(action);
        addAttribute(wsaddressingElement,soapNS,"mustUnderstand",  "1");
        wsaddressingElement=writeElement( "http://www.w3.org/2005/08/addressing","MessageID",xml);
        header.appendChild(wsaddressingElement);
        wsaddressingElement.setTextContent("urn:uuid:" + UUID.randomUUID());
        wsaddressingElement=writeElement( "http://www.w3.org/2005/08/addressing","ReplyTo", xml);

        header.appendChild(wsaddressingElement);
        org.w3c.dom.Element innerWsaddressingElement=writeElement("http://www.w3.org/2005/08/addressing","Address", xml);
        innerWsaddressingElement.setTextContent(replyTo);
        wsaddressingElement.appendChild(innerWsaddressingElement);

        wsaddressingElement=writeElement( "http://www.w3.org/2005/08/addressing","To", xml);
        header.appendChild(wsaddressingElement);
        wsaddressingElement.setTextContent(to);
        addAttribute( wsaddressingElement,soapNS,"mustUnderstand",  "1");
        
        for (String param : referenceParameters) 
        {
            try {
                org.w3c.dom.Document root = SVMHelper.loadXMLFromString(param);
                org.w3c.dom.Element element=(org.w3c.dom.Element)header.getOwnerDocument().adoptNode(root.getDocumentElement());
                header.appendChild(element);
                addAttribute(element, "http://www.w3.org/2005/08/addressing","IsReferenceParameter",  "true");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }            
        }
    }
    
    public void setAnyTypeValue(Object item, org.w3c.dom.Element propertyElement)
    {
        if (item instanceof SVMISerializableObject)
        {
            SVMISerializableObject obj=(SVMISerializableObject)item;
            obj.serialize(propertyElement ,this);
            return;
        }
        String prefix=ensureNamespace( "http://www.w3.org/2001/XMLSchema",propertyElement.getOwnerDocument(),null);
        if(item instanceof String)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":string");
        }
        else if(item instanceof Boolean)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":boolean");
        }
        else if (item instanceof Integer)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":int");
        }
        else if (item instanceof Double)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":double");
        }
        else if (item instanceof Float)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":float");
        }
        else if (item instanceof Long)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":long");
        }
        else if (item instanceof Short)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":short");
        }
        else if (item instanceof java.math.BigDecimal)
        {
            addAttribute(propertyElement,"http://www.w3.org/2001/XMLSchema-instance","type",  prefix+":decimal");
        }
        propertyElement.setTextContent(item.toString());
    }

    public Object getAnyTypeValue(org.w3c.dom.Element node)
    {
        String typeAttr=node.getAttributeNS(SVMHelper.XSI,"type");
        if (!SVMHelper.isEmpty(typeAttr))
        {
            String[] splitString=typeAttr.split(":");
            if (splitString.length==2)
            {
                String namespace=node.lookupNamespaceURI( splitString[0]);
                if (namespace.equals("http://www.w3.org/2001/XMLSchema"))
                {
                    String value=splitString[1];
                    if( value.equals("byte"))
                    {
                        return Byte.valueOf(node.getTextContent());
                    }
                    if( value.equals("unsignedByte"))
                    {
                        return Integer.valueOf(node.getTextContent());
                    }
                    if( value.equals("positiveInteger"))
                    {
                        return Integer.valueOf(node.getTextContent());
                    }
                    if( value.equals( "double"))
                    {
                        return Double.valueOf(node.getTextContent());
                    }
                    if( value.equals("float"))
                    {
                        return Float.valueOf(node.getTextContent());
                    }
                    if( value.equals("long"))
                    {
                        return Long.valueOf(node.getTextContent());
                    }
                    if( value.equals("unsignedLong"))
                    {
                        return Long.valueOf(node.getTextContent());
                    }
                    if( value.equals("int") || value.equals("integer") || value.equals("negativeInteger") || value.equals("nonNegativeInteger"))
                    {
                        return Integer.valueOf(node.getTextContent());
                    }
                    if( value.equals("unsignedInt"))
                    {
                        return Long.valueOf(node.getTextContent());
                    }
                    if( value.equals("decimal"))
                    {
                        return new java.math.BigDecimal(node.getTextContent());
                    }
                    if( value.equals("short"))
                    {
                        return Short.valueOf(node.getTextContent());
                    }
                    if( value.equals("unsignedShort"))
                    {
                        return Integer.valueOf(node.getTextContent());
                    }
                    else if (value.equals("bool"))
                    {
                        return node.getTextContent().equalsIgnoreCase("true");
                    }
                    else
                    {
                        return  node.getTextContent();
                    }
                }
                else
                {
                    String typeName=typeAttr;
                    if(splitString.length==2)
                    {
                        typeName= splitString[1];
                    }
                    if (namespace != null)
                    {
                        String classType=namespace+"^^" + typeName;
                        java.lang.Class temp=classNames.get(classType);
                        if (temp != null)
                        {
                            Object obj = createInstance(node, temp);
                            return obj;
                        }
                    }
                }
            }
        }
        return node;
    }
    
    private String ensureNamespace(String namespace,org.w3c.dom.Document doc,String defaultPrefix)
    {
        String prefix="";
        if(!SVMHelper.isEmpty(namespace))
        {
            if(namespaces.containsKey(namespace))
            {
                prefix=namespaces.get(namespace);
            }
            else
            {
                prefix=defaultPrefix!=null?defaultPrefix:"ns"+namespaces.size();
                namespaces.put(namespace,prefix);
                doc.getDocumentElement().setAttribute("xmlns:"+prefix,namespace);
            }
        }
        return prefix;
    }

    public org.w3c.dom.Element writeElement(String namespace, String name, org.w3c.dom.Document doc)
    {
        String prefix=ensureNamespace(namespace,doc,null);
        org.w3c.dom.Element element= doc.createElementNS(namespace,name);
        if(!SVMHelper.isEmpty(prefix))
        {
            element.setPrefix(prefix);
        }
        return element;
    }

    public org.w3c.dom.Element writeElementWithType(Object obj, Class type, String name,String namespace, org.w3c.dom.Element parent, boolean skipNullProperty)
    {
        if (obj == null && skipNullProperty)
        {
            return null;
        }
        org.w3c.dom.Element propertyElement=writeElement(namespace,name,parent.getOwnerDocument());
        parent.appendChild(propertyElement);

        if (obj==null)
        {
            propertyElement.setAttributeNS(SVMHelper.XSI,"xsi:nil","true");
            return null;
        }

        if  (obj instanceof SVMIReferenceObject)
        {
            String idStr=reverseReferencesTable.get(obj);
            if (idStr != null)
            {
                propertyElement.setAttributeNS(SVMHelper.MS_SERIALIZATION_NS,"ms:Ref",idStr);
                return null;
            }

            idStr="i"+ (reverseReferencesTable.size() + 1);
            propertyElement.setAttributeNS(SVMHelper.MS_SERIALIZATION_NS,"ms:Id",idStr);
            reverseReferencesTable.put(obj,idStr);
        }

        java.lang.Class currentType=obj.getClass();
        if (currentType != type)
        {
            String xmlType=reverseClassNames.get(currentType);
            if (xmlType != null)
            {
                String[] splitType = xmlType.split("\\^\\^");
                String fullname=getXmlFullName(propertyElement, splitType[0],splitType[1]);
                propertyElement.setAttributeNS(SVMHelper.XSI,"xsi:type",fullname);
            }
        }

        return propertyElement;
    }

    public org.w3c.dom.Document setResponse(SVMResponseData response) throws java.lang.Exception 
    {
        if(SVMHelper.isEmpty(response.getBody()))
        {
            throw new java.lang.Exception("No body content");
        }
        org.w3c.dom.Document parsedXml = SVMHelper.loadXMLFromString(response.getBody());

        if(parsedXml.getDocumentElement()==null)
        {
            throw new java.lang.Exception(response.getBody());
        }

        outputBody= SVMHelper.getElement(parsedXml.getDocumentElement(),soapNS,"Body");
        outputHeader=SVMHelper.getElement(parsedXml.getDocumentElement(),soapNS,"Header");

        if(outputBody==null)
        {
            throw new java.lang.Exception(response.getBody());
        }

        org.w3c.dom.Element fault=SVMHelper.getElement(outputBody, soapNS,"Fault");
        if (fault != null)
        {
            org.w3c.dom.Element faultString=SVMHelper.getNodeByLocalName(fault, "faultstring",0);
            if (faultString == null)
            {
                org.w3c.dom.Element reasonNode=SVMHelper.getNodeByLocalName(fault, "Reason",0);
                if( reasonNode != null)
                {
                    faultString=SVMHelper.getNodeByLocalName(reasonNode, "Text",0);
                }
            }

            org.w3c.dom.Element faultDetail=SVMHelper.getNodeByLocalName( fault, "detail",0);
            if (faultDetail == null)
            {
                faultDetail=SVMHelper.getNodeByLocalName(fault, "Detail",0);
            }

            if (faultDetail != null)
            {
                org.w3c.dom.Element faultClass=SVMHelper.getFirstChildElement(faultDetail);
                if (faultClass != null)
                {
                    String typeName=faultClass.getLocalName();
                    String namespaceNode=parsedXml.lookupNamespaceURI(typeName);
                    String namespace;
                    if(namespaceNode==null)
                    {
                        namespace=faultClass.getNamespaceURI();
                    }
                    else
                    {
                        namespace=namespaceNode;
                    }
                    String classType=namespace+"^^"+typeName;
                    String tempKey=elementNames.get(classType);
                    if (tempKey != null)
                    {
                        classType=tempKey;
                    }
                    java.lang.Class temp=classNames.get(classType);
                    if (temp != null)
                    {
                        Object faultObj=createInstance(faultClass, temp);
                        java.lang.Exception faultException;
                        if(!(faultObj instanceof java.lang.Exception))
                        {
                            faultException = new SVMSoapException(faultObj);
                        }
                        else
                        {
                            faultException=(java.lang.Exception) faultObj; 
                        }
                        throw faultException;
                    }
                }
            }
            throw new SVMSoapException(faultString.getTextContent(),faultDetail);
        }

        return parsedXml;
    }

    public Object createObject(org.w3c.dom.Element node, java.lang.Class type)
    {
        if(node==null)
        {
            return null;
        }
        java.lang.Class objType=type;
        org.w3c.dom.Element element=node;

        String refAttr=node.getAttributeNS(SVMHelper.MS_SERIALIZATION_NS,"Ref");
        if (!SVMHelper.isEmpty(refAttr))
        {
            return referencesTable.get(refAttr);
        }

        String nilAttr=node.getAttributeNS(SVMHelper.XSI,"nil");
        if (nilAttr != null && SVMHelper.toBoolFromString( nilAttr))
        {
            return null;
        }

        String typeAttr=node.getAttributeNS(SVMHelper.XSI,"type");
        if (!SVMHelper.isEmpty(typeAttr))
        {
            String[] splitString=typeAttr.split(":");
            String namespace = null;
            if(splitString.length==2)
            {
                namespace=node.lookupNamespaceURI(splitString[0]);
            }
            if(namespace==null)
            {
                namespace="";
            }
            String typeName=typeAttr;
            if(splitString.length == 2)
            {
                typeName=splitString[1];
            }
            String classType=namespace+"^^"+typeName;
            if(classNames.containsKey(classType))
            {
                objType=classNames.get(classType);
            }
        }

        String hrefAttr = node.getAttribute("href");
        if (SVMHelper.isEmpty(hrefAttr))
        {
            hrefAttr = node.getAttribute("ref");
        }

        if (!SVMHelper.isEmpty(hrefAttr))
        {
            String hrefId=hrefAttr.substring(1);
            org.w3c.dom.Element tempNode=node.getOwnerDocument().getElementById(hrefId);

            if (tempNode!=null)
            {
                element=tempNode;
            }
        }
        
        if(objType!=null)
        {
            Object obj=createInstance(element,objType);
            return obj;
        }
        return null;
    }
    
    private Object createInstance(org.w3c.dom.Element node, java.lang.Class objType)
    {
        try
        {
            SVMISerializableObject obj = (SVMISerializableObject)objType.newInstance();
            String idAttr=node.getAttributeNS(SVMHelper.MS_SERIALIZATION_NS,"Id");
            if (!SVMHelper.isEmpty(idAttr))
            {
                referencesTable.put(idAttr,obj);
            }
            obj.loadWithXml(node,this);
            return obj;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private String getXmlFullName(org.w3c.dom.Element element,String uri, String name)
    {
        String prefix=ensureNamespace(uri,element.getOwnerDocument(),null);
        String fullname=name;
        if (!SVMHelper.isEmpty(prefix))
        {
            fullname=prefix+":"+name;
        }
        return fullname;
    }

    public boolean hasAttribute(org.w3c.dom.Element node,String namespace,String name)
    {
        String ns=namespace;
        if(SVMHelper.isEmpty(namespace))
        {
            ns=null;
        }
        return node.hasAttributeNS(ns,name);
    }

    public org.w3c.dom.Attr getAttribute(org.w3c.dom.Element node,String namespace,String name)
    {
        String ns=namespace;
        if(SVMHelper.isEmpty(namespace))
        {
            ns=null;
        }
        return node.getAttributeNodeNS(ns,name);
    }
}