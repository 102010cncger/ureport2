package com.bstek.ureport.definition.value;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Jacky.gao
 * @since 2017年3月14日
 */
public class SlashValue implements Value {
	private String svg;
	private List<Slash> slashes;
	@JsonIgnore
	private String base64Data;
	@Override
	public String getValue() {
		return null;
	}
	
	public String getSvg() {
		return svg;
	}

	public void setSvg(String svg) {
		this.svg = svg;
	}

	public List<Slash> getSlashes() {
		return slashes;
	}

	public void setSlashes(List<Slash> slashes) {
		this.slashes = slashes;
	}

	@Override
	public ValueType getType() {
		return ValueType.slash;
	}

	public String getBase64Data() {
		return base64Data;
	}

	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}
}
