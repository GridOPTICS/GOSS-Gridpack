package pnnl.goss.gridpack.model.impl;

import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pnnl.goss.gridpack.model.TransmissionElements;

@XmlRootElement(name="TransmissionElements")
public class TransmissionElementsImpl implements TransmissionElements {

    private List<TransmissionElementLineImpl> lines;
    private List<TransmissionElementTransformerImpl> transformers;

    private TransmissionElementsImpl(){

    }

    public TransmissionElementsImpl(List<TransmissionElementLineImpl> lines, List<TransmissionElementTransformerImpl> transformers){
        this.lines = lines;
        this.transformers = transformers;
    }

    @XmlElement(name="Line")
    public Collection<TransmissionElementLineImpl> getLines(){
        return lines;
    }

    @XmlElement(name="Transformer")
    public Collection<TransmissionElementTransformerImpl> getTransformers(){
        return transformers;
    }
}
