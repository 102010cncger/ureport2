package com.bstek.ureport.build.compute;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.value.ImageValue;
import com.bstek.ureport.definition.value.Source;
import com.bstek.ureport.definition.value.ValueType;
import com.bstek.ureport.expression.model.Expression;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.image.ImageType;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Image;
import com.bstek.ureport.utils.ImageUtils;

/**
 * @author Jacky.gao
 * @since 2017年1月24日
 */
public class ImageValueCompute implements ValueCompute{
	@Override
	public List<BindData> compute(Cell cell, Context context) {
		ImageValue value=(ImageValue)cell.getValue();
		Source source=value.getSource();
		List<BindData> list=new ArrayList<BindData>();
		if(source.equals(Source.text)){
			String base64Data=ImageUtils.getImageBase64Data(ImageType.image, value.getValue());
			list.add(new BindData(new Image(base64Data,value.getValue(),-1,-1)));			
		}else{
			Expression expression=value.getExpression();
			ExpressionData<?> data=expression.execute(cell,cell, context);
			Object obj=data.getData();
			if(obj instanceof List){
				List<?> listData=(List<?>)obj;
				for(Object o:listData){
					if(o!=null){
						String base64Data=ImageUtils.getImageBase64Data(ImageType.image, o.toString());
						list.add(new BindData(new Image(base64Data,o.toString(),-1,-1)));						
					}
				}
			}else if(obj instanceof String){
				String text=obj.toString();
				if(text.startsWith("\"") && text.endsWith("\"")){
					text=text.substring(1,text.length()-1);
				}
				String base64Data=ImageUtils.getImageBase64Data(ImageType.image, text);
				list.add(new BindData(new Image(base64Data,text,-1,-1)));			
			}else{
				if(obj!=null){
					String base64Data=ImageUtils.getImageBase64Data(ImageType.image, obj.toString());
					list.add(new BindData(new Image(base64Data,obj.toString(),-1,-1)));					
				}
			}
		}
		return list;
	}
	@Override
	public ValueType type() {
		return ValueType.image;
	}
}
