package com.bstek.ureport.export.pdf;

import org.apache.commons.lang.StringUtils;

import com.bstek.ureport.definition.CellStyle;
import com.bstek.ureport.export.pdf.font.FontBuilder;
import com.bstek.ureport.model.Cell;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;

/**
 * @author Jacky.gao
 * @since 2014年4月17日
 */
public class CellPhrase extends Phrase {
	private static final long serialVersionUID = 8712267867853876619L;
	public CellPhrase(Cell cell,Object cellData){
		String text="";
		if(cellData!=null){
			text=cellData.toString();
		}
		Font font=buildPdfFont(cell);
		setFont(font);
		add(text);			
	}
	
	private Font buildPdfFont(Cell cell){
		CellStyle style=cell.getCellStyle();
		CellStyle customStyle=cell.getCustomCellStyle();
		CellStyle rowStyle=cell.getRow().getCustomCellStyle();
		CellStyle colStyle=cell.getColumn().getCustomCellStyle();
		String fontName=style.getFontFamily();
		if(customStyle!=null && StringUtils.isNotBlank(customStyle.getFontFamily())){
			fontName=customStyle.getFontFamily();
		}
		if(rowStyle!=null && StringUtils.isNotBlank(rowStyle.getFontFamily())){
			fontName=rowStyle.getFontFamily();
		}
		if(colStyle!=null && StringUtils.isNotBlank(colStyle.getFontFamily())){
			fontName=colStyle.getFontFamily();
		}
		Boolean bold=style.getBold(),italic=style.getItalic(),underline=style.getUnderline();
		if(customStyle!=null){
			if(customStyle.getBold()!=null){
				bold=customStyle.getBold();
			}
			if(customStyle.getItalic()!=null){
				italic=customStyle.getItalic();
			}
			if(customStyle.getUnderline()!=null){
				underline=customStyle.getUnderline();
			}
		}
		if(rowStyle!=null){
			if(rowStyle.getBold()!=null){
				bold=rowStyle.getBold();
			}
			if(rowStyle.getItalic()!=null){
				italic=rowStyle.getItalic();
			}
			if(rowStyle.getUnderline()!=null){
				underline=rowStyle.getUnderline();
			}
		}
		if(colStyle!=null){
			if(colStyle.getBold()!=null){
				bold=colStyle.getBold();
			}
			if(colStyle.getItalic()!=null){
				italic=colStyle.getItalic();
			}
			if(colStyle.getUnderline()!=null){
				underline=colStyle.getUnderline();
			}
		}
		if(bold==null)bold=false;
		if(italic==null)italic=false;
		if(underline==null)underline=false;
		Font font=FontBuilder.getFont(fontName, style.getFontSize(),bold,italic,underline);
		String fontColor=style.getForecolor();
		if(customStyle!=null && StringUtils.isNotBlank(customStyle.getForecolor())){
			fontColor=customStyle.getForecolor();
		}
		if(rowStyle!=null && StringUtils.isNotBlank(rowStyle.getForecolor())){
			fontColor=rowStyle.getForecolor();
		}
		if(colStyle!=null && StringUtils.isNotBlank(colStyle.getForecolor())){
			fontColor=colStyle.getForecolor();
		}
		if(StringUtils.isNotEmpty(fontColor)){
			String[] color=fontColor.split(",");
			font.setColor(Integer.valueOf(color[0]), Integer.valueOf(color[1]), Integer.valueOf(color[2]));			
		}
		return font;
	}
}
