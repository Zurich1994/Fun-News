package com.heu.dao;

import java.util.List;



import com.heu.service.AllServiceImpl;
import com.heu.service.FunServiceImpl;
import com.heu.service.PhotoServiceImpl;
import com.heu.service.SoundServiceImpl;
import com.heu.service.UserDaoImpl;
import com.heu.service.VideoServiceImpl;

public class Tools {
private StringBuffer sb1;
private StringBuffer sb2;
public String showAll(String time,int operate)
{
	List<All>lists=AllServiceImpl.getlist(time,operate);
	//String url="http://192.168.191.8:8080/Service/Image/";
	sb2=new StringBuffer();
	 sb2.append('[');  
     
    for (All all: lists) {
          sb2.append('{').append("\"user_head\":").append("\""+all.getUser_head()+"\"").append(",");  
          sb2.append("\"user_name\":").append("\""+all.getUser_name()+"\"").append(",");  
          sb2.append("\"fun_time\":").append("\""+all.getFun_time().substring(0, all.getFun_time().length()-5)+"\"").append(","); 
          sb2.append("\"fun_content\":").append("\""+all.getFun_content()+"\"").append(","); 
          sb2.append("\"fun_id\":").append("\""+all.getFun_id()+"\"").append(",");  
          sb2.append("\"photo_name\":").append("\""+all.getPhoto_name()+"\"").append(",");
          sb2.append("\"video_name\":").append("\""+all.getVideo_name()+"\"").append(",");
          sb2.append("\"sound_name\":").append("\""+all.getSound_name()+"\"").append(",");
          sb2.append("\"praise_count\":").append("\""+String.valueOf(all.getPraise_count())+"\"").append(",");
          sb2.append("\"down_count\":").append("\""+String.valueOf(all.getDown_count())+"\"").append(",");
          sb2.append("\"comment_count\":").append("\""+String.valueOf(all.getComment_count())+"\"").append(",");
          sb2.append("\"share_count\":").append("\""+String.valueOf(all.getShare_count()+"\"")).append(",");
          sb2.append("\"sign1\":").append("\""+all.getSign1()+"\"").append(",");
          sb2.append("\"sign2\":").append("\""+all.getSign2()+"\"").append(",");
          sb2.append("\"sign3\":").append("\""+all.getSign3()+"\"").append(",");
          sb2.append("\"type\":").append("\""+all.getSerise()+"\"");
          
          sb2.append('}').append(",");  
      }  
      sb2.deleteCharAt(sb2.length() - 1);  
     sb2.append(']'); 
     System.out.println(new String(sb2).toString());
     return (new String(sb2).toString());
	}
public String showfun(int user_id,int operate,String time)
{
	List<Fun>lists=FunServiceImpl.getList(user_id, operate,time);
	//String url="http://192.168.191.8:8080/Service/Image/";
	sb1=new StringBuffer();
	 sb1.append('[');  
     
    for (Fun fun : lists) {
          sb1.append('{').append("\"user_head\":").append("\""+fun.getUser_head()+"\"").append(",");  
          sb1.append("\"user_name\":").append("\""+fun.getUser_name()+"\"").append(",");  
          sb1.append("\"fun_time\":").append("\""+fun.getFun_time().substring(0, fun.getFun_time().length()-5)+"\"").append(","); 
          sb1.append("\"fun_content\":").append("\""+fun.getFun_content()+"\"").append(","); 
          sb1.append("\"fun_id\":").append("\""+fun.getFun_id()+"\"").append(",");  
          sb1.append("\"praise_count\":").append("\""+String.valueOf(fun.getPraise_count())+"\"").append(",");
          sb1.append("\"down_count\":").append("\""+String.valueOf(fun.getDown_count())+"\"").append(",");
          sb1.append("\"comment_count\":").append("\""+String.valueOf(fun.getComment_count())+"\"").append(",");
          sb1.append("\"share_count\":").append("\""+String.valueOf(fun.getShare_count()+"\"")).append(",");
          sb1.append("\"sign1\":").append("\""+fun.getSign1()+"\"").append(",");
          sb1.append("\"sign2\":").append("\""+fun.getSign2()+"\"").append(",");
          sb1.append("\"sign3\":").append("\""+fun.getSign3()+"\"").append(",");
          sb1.append("\"type\":").append("\""+fun.getSerise()+"\"");
          
          sb1.append('}').append(",");  
      }  
      sb1.deleteCharAt(sb1.length() - 1);  
     sb1.append(']'); 
     return (new String(sb1).toString());
	}

public String showPhoto(int user_id,int operate,String time)
{
	List<Photo>lists=PhotoServiceImpl.getList(user_id, operate,time);
	//String url="http://192.168.191.8:8080/Service/Image/";
	sb2=new StringBuffer();
	 sb2.append('[');  
     
    for (Photo photo: lists) {
          sb2.append('{').append("\"user_head\":").append("\""+photo.getUser_head()+"\"").append(",");  
          sb2.append("\"user_name\":").append("\""+photo.getUser_name()+"\"").append(",");  
          sb2.append("\"fun_time\":").append("\""+photo.getFun_time().substring(0, photo.getFun_time().length()-5)+"\"").append(","); 
          sb2.append("\"fun_content\":").append("\""+photo.getFun_content()+"\"").append(","); 
          sb2.append("\"fun_id\":").append("\""+photo.getFun_id()+"\"").append(",");  
          sb2.append("\"photo_name\":").append("\""+photo.getPhoto_name()+"\"").append(",");
          sb2.append("\"praise_count\":").append("\""+String.valueOf(photo.getPraise_count())+"\"").append(",");
          sb2.append("\"down_count\":").append("\""+String.valueOf(photo.getDown_count())+"\"").append(",");
          sb2.append("\"comment_count\":").append("\""+String.valueOf(photo.getComment_count())+"\"").append(",");
          sb2.append("\"share_count\":").append("\""+String.valueOf(photo.getShare_count()+"\"")).append(",");
          sb2.append("\"sign1\":").append("\""+photo.getSign1()+"\"").append(",");
          sb2.append("\"sign2\":").append("\""+photo.getSign2()+"\"").append(",");
          sb2.append("\"sign3\":").append("\""+photo.getSign3()+"\"").append(",");
          sb2.append("\"type\":").append("\""+photo.getSerise()+"\"");
          
          sb2.append('}').append(",");  
      }  
      sb2.deleteCharAt(sb2.length() - 1);  
     sb2.append(']'); 
     return (new String(sb2).toString());
	}

public String showVideo(int user_id,int operate,String time)
{
	List<Video>lists=VideoServiceImpl.getList(user_id, operate,time);
	//String url="http://192.168.191.8:8080/Service/Image/";
	sb2=new StringBuffer();
	 sb2.append('[');  
     
    for (Video video: lists) {
          sb2.append('{').append("\"user_head\":").append("\""+video.getUser_head()+"\"").append(",");  
          sb2.append("\"user_name\":").append("\""+video.getUser_name()+"\"").append(",");  
          sb2.append("\"fun_time\":").append("\""+video.getFun_time().substring(0, video.getFun_time().length()-5)+"\"").append(","); 
          sb2.append("\"fun_content\":").append("\""+video.getFun_content()+"\"").append(","); 
          sb2.append("\"fun_id\":").append("\""+video.getFun_id()+"\"").append(","); 
          sb2.append("\"photo_name\":").append("\""+video.getPhoto_name()+"\"").append(",");
          sb2.append("\"video_name\":").append("\""+video.getVideo_name()+"\"").append(",");
          sb2.append("\"praise_count\":").append("\""+String.valueOf(video.getPraise_count())+"\"").append(",");
          sb2.append("\"down_count\":").append("\""+String.valueOf(video.getDown_count())+"\"").append(",");
          sb2.append("\"comment_count\":").append("\""+String.valueOf(video.getComment_count())+"\"").append(",");
          sb2.append("\"share_count\":").append("\""+String.valueOf(video.getShare_count()+"\"")).append(",");
          sb2.append("\"sign1\":").append("\""+video.getSign1()+"\"").append(",");
          sb2.append("\"sign2\":").append("\""+video.getSign2()+"\"").append(",");
          sb2.append("\"sign3\":").append("\""+video.getSign3()+"\"").append(",");
          sb2.append("\"type\":").append("\""+video.getSerise()+"\"");
          
          sb2.append('}').append(",");  
      }  
      sb2.deleteCharAt(sb2.length() - 1);  
     sb2.append(']'); 
     return (new String(sb2).toString());
	}
public String showSound(int user_id,int operate,String time)
{
	List<Sound>lists=SoundServiceImpl.getList(user_id, operate,time);
	//String url="http://192.168.191.8:8080/Service/Image/";
	sb2=new StringBuffer();
	 sb2.append('[');  
     
    for (Sound video: lists) {
          sb2.append('{').append("\"user_head\":").append("\""+video.getUser_head()+"\"").append(",");  
          sb2.append("\"user_name\":").append("\""+video.getUser_name()+"\"").append(",");  
          sb2.append("\"fun_time\":").append("\""+video.getFun_time().substring(0, video.getFun_time().length()-5)+"\"").append(","); 
          sb2.append("\"fun_content\":").append("\""+video.getFun_content()+"\"").append(","); 
          sb2.append("\"fun_id\":").append("\""+video.getFun_id()+"\"").append(","); 
          sb2.append("\"photo_name\":").append("\""+video.getPhoto_name()+"\"").append(",");
          sb2.append("\"sound_name\":").append("\""+video.getSound_name()+"\"").append(",");
          sb2.append("\"praise_count\":").append("\""+String.valueOf(video.getPraise_count())+"\"").append(",");
          sb2.append("\"down_count\":").append("\""+String.valueOf(video.getDown_count())+"\"").append(",");
          sb2.append("\"comment_count\":").append("\""+String.valueOf(video.getComment_count())+"\"").append(",");
          sb2.append("\"share_count\":").append("\""+String.valueOf(video.getShare_count()+"\"")).append(",");
          sb2.append("\"sign1\":").append("\""+video.getSign1()+"\"").append(",");
          sb2.append("\"sign2\":").append("\""+video.getSign2()+"\"").append(",");
          sb2.append("\"sign3\":").append("\""+video.getSign3()+"\"").append(",");
          sb2.append("\"type\":").append("\""+video.getSerise()+"\"");
          
          sb2.append('}').append(",");  
      }  
      sb2.deleteCharAt(sb2.length() - 1);  
     sb2.append(']'); 
     return (new String(sb2).toString());
	}
public boolean isTure(String account,String password)
{
	UserDaoImpl udi=new UserDaoImpl();
	return udi.isTure(account, password);
	}
}
