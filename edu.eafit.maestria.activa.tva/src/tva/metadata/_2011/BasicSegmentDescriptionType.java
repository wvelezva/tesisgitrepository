//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import tva.metadata.extended._2011.ExtendedSegmentDescriptionType;
import tva.mpeg7._2008.TitleType;


/**
 * <p>Java class for BasicSegmentDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasicSegmentDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Title" type="{urn:tva:mpeg7:2008}TitleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Synopsis" type="{urn:tva:metadata:2011}SynopsisType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Genre" type="{urn:tva:metadata:2011}GenreType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{urn:tva:metadata:2011}KeywordType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelatedMaterial" type="{urn:tva:metadata:2011}RelatedMaterialType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreditsList" type="{urn:tva:metadata:2011}CreditsListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicSegmentDescriptionType", propOrder = {
    "title",
    "synopsis",
    "genre",
    "keyword",
    "relatedMaterial",
    "creditsList"
})
@XmlSeeAlso({
    ExtendedSegmentDescriptionType.class
})
public class BasicSegmentDescriptionType {

    @XmlElement(name = "Title")
    protected List<TitleType> title;
    @XmlElement(name = "Synopsis")
    protected List<SynopsisType> synopsis;
    @XmlElement(name = "Genre")
    protected List<GenreType> genre;
    @XmlElement(name = "Keyword")
    protected List<KeywordType> keyword;
    @XmlElement(name = "RelatedMaterial")
    protected List<RelatedMaterialType> relatedMaterial;
    @XmlElement(name = "CreditsList")
    protected CreditsListType creditsList;

    /**
     * Gets the value of the title property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the title property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TitleType }
     * 
     * 
     */
    public List<TitleType> getTitle() {
        if (title == null) {
            title = new ArrayList<TitleType>();
        }
        return this.title;
    }

    /**
     * Gets the value of the synopsis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the synopsis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSynopsis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SynopsisType }
     * 
     * 
     */
    public List<SynopsisType> getSynopsis() {
        if (synopsis == null) {
            synopsis = new ArrayList<SynopsisType>();
        }
        return this.synopsis;
    }

    /**
     * Gets the value of the genre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenreType }
     * 
     * 
     */
    public List<GenreType> getGenre() {
        if (genre == null) {
            genre = new ArrayList<GenreType>();
        }
        return this.genre;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeywordType }
     * 
     * 
     */
    public List<KeywordType> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<KeywordType>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the relatedMaterial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedMaterial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedMaterial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedMaterialType }
     * 
     * 
     */
    public List<RelatedMaterialType> getRelatedMaterial() {
        if (relatedMaterial == null) {
            relatedMaterial = new ArrayList<RelatedMaterialType>();
        }
        return this.relatedMaterial;
    }

    /**
     * Gets the value of the creditsList property.
     * 
     * @return
     *     possible object is
     *     {@link CreditsListType }
     *     
     */
    public CreditsListType getCreditsList() {
        return creditsList;
    }

    /**
     * Sets the value of the creditsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditsListType }
     *     
     */
    public void setCreditsList(CreditsListType value) {
        this.creditsList = value;
    }

}
