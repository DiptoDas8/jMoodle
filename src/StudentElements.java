


import java.io.*;
public class StudentElements implements Serializable {
	private String Name;
	  private String LT;
	  private String Address;

   
	  private String Email;
	  private String StndID;
	  private String ContactNo;
	  private int notification;
	  private String UserID;
	  private String Pass;
	  private int messages;
	  private int unreadnoti;

    
	  public int getUnreadnoti() {
		return unreadnoti;
	}
	public void setUnreadnoti(int unreadnoti) {
		this.unreadnoti = unreadnoti;
	}

	private int Noticapacity;
	  private int Msgcapacity;
	  private noticeClass[] allnoti;
	  private String[] allmsg;

	public StudentElements(String name, String lT, String address,
			String email, String stndID, String contactNo,String  userID,String pass) {
		Name = name;
		LT = lT;
		Address = address;
		Email = email;
		StndID = stndID;
		ContactNo = contactNo;
		UserID=userID;
		Pass=pass;
		Noticapacity=10;
		Msgcapacity=10;
		notification=0;
		messages=0;
                unreadnoti=0;
		allnoti=new noticeClass[Noticapacity];
		allmsg=new String[Msgcapacity];
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public int getMessages() {
		return messages;
	}
        public void AddNoti(noticeClass n){
            if(notification<Noticapacity){
                allnoti[notification]=n;
                notification++;
            }
            else{
                for(int i=0;i<Noticapacity;++i){
                    allnoti[i]=allnoti[i+1];
                }
                allnoti[notification]=n;
            }
            if(unreadnoti<Noticapacity){
                unreadnoti++;
            }
        }
        public String shownotification(){
            String s="";
            int j=1;
            for(int i=notification-1;i>=0;--i){
                System.out.println(allnoti[i]);
                System.out.println(" ");
                s=s+j+" ";
                if(j<=unreadnoti){
                    s=s+"(NEW NOTIFICATION!!)";
                }
                s=s+"\n"+allnoti[i]+"\n\n";
                j++;
            }
            return s;
        }
	public void setMessages(int messages) {
		this.messages = messages;
	}
	public int getNoticapacity() {
		return Noticapacity;
	}
	public void setNoticapacity(int noticapacity) {
		Noticapacity = noticapacity;
	}
	public int getMsgcapacity() {
		return Msgcapacity;
	}
	public void setMsgcapacity(int msgcapacity) {
		Msgcapacity = msgcapacity;
	}
public int getNotification() {
	return notification;
}
public void setNotification(int notification) {
	this.notification = notification;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getLT() {
	return LT;
}
public void setLT(String lT) {
	LT = lT;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getStndID() {
	return StndID;
}
public void setStndID(String stndID) {
	StndID = stndID;
}
public String getContactNo() {
	return ContactNo;
}
public void setContactNo(String contactNo) {
	ContactNo = contactNo;
}

@Override
public String toString() {
	return "StudentElements [Name=" + Name + ", LT=" + LT + ", Address="
			+ Address + ", Email=" + Email + ", StndID=" + StndID
			+ ", ContactNo=" + ContactNo + ", UserID=" + UserID + "]";
}
  
}
