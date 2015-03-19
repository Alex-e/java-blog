package ua.ieromenko.jb.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.stereotype.Service;

import ua.ieromenko.jb.entity.Item;
import ua.ieromenko.jb.exception.RssException;
import ua.ieromenko.jb.rss.ObjectFactory;
import ua.ieromenko.jb.rss.TRss;
import ua.ieromenko.jb.rss.TRssChannel;
import ua.ieromenko.jb.rss.TRssItem;

@Service
public class RssService {
	
	public List<Item> getItems(Source source) throws RssException {
		List<Item> list = new ArrayList<Item>();
		try {
		  JAXBContext context =	JAXBContext.newInstance(ObjectFactory.class);
		  Unmarshaller unmarshaller =  context.createUnmarshaller();
		  JAXBElement<TRss> jaxbElement =  unmarshaller.unmarshal(source, TRss.class);
		  TRss tRss = jaxbElement.getValue();
		  
		  List<TRssChannel> channels = tRss.getChannel();
		  for (TRssChannel channel: channels) {
			  List<TRssItem> items = channel.getItem();
			  for (TRssItem tRssItem : items) {
				  Item item = new Item();
				  item.setTitle(tRssItem.getTitle());
				  item.setDescription(tRssItem.getDescription());
				  item.setLink(tRssItem.getLink());
				  Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(tRssItem.getPubDate());
				  item.setPublishedDate(pubDate);
				  list.add(item);
			  }
		  }
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throw new RssException(e);
		}
		return list;
		
	}

}
