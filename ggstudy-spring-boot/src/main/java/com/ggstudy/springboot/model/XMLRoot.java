package com.ggstudy.springboot.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "xmlRoot")
public class XMLRoot {
    @JacksonXmlProperty(localName="jojo")
    private Object jo;
}
