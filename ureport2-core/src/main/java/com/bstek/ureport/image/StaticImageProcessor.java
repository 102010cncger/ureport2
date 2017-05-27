package com.bstek.ureport.image;

import java.io.InputStream;
import java.util.Collection;

import com.bstek.ureport.Utils;
import com.bstek.ureport.exception.ReportComputeException;
import com.bstek.ureport.provider.image.ImageProvider;

/**
 * @author Jacky.gao
 * @since 2017年3月20日
 */
public class StaticImageProcessor implements ImageProcessor<String> {
	@Override
	public InputStream getImage(String path) {
		Collection<ImageProvider> imageProviders=Utils.getImageProviders();
		ImageProvider targetImageProvider=null;
		for(ImageProvider provider:imageProviders){
			if(provider.support(path)){
				targetImageProvider=provider;
				break;
			}
		}
		if(targetImageProvider==null){
			throw new ReportComputeException("Unsupport image path :"+path);
		}
		InputStream inputStream=targetImageProvider.getImage(path);
		return inputStream;
	}
}
