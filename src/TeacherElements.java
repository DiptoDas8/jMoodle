


import java.io.*;
public class TeacherElements implements Serializable {
	private String Name;
	  private String Address;

   
	  private String Email;
	  private String ContactNo;
	  private String UserID;
	  private String Pass;
	  private int messages;
          private String Position;
	  private int Msgcapacity;
	  private String[] allmsg;

	public TeacherElements(String name, String address,
			String email, String contact, String ID,String  pass,String pos) {
		Name = name;
		Address = address;
		Email = email;
		ContactNo = contact;
		UserID=ID;
		Pass=pass;
		
		Msgcapacity=10;
		messages=0;
                Position=pos;
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
       
	public void setMessages(int messages) {
		this.messages = messages;
	}
	
	public int getMsgcapacity() {
		return Msgcapacity;
	}
	public void setMsgcapacity(int msgcapacity) {
		Msgcapacity = msgcapacity;
	}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
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
public String getContactNo() {
	return ContactNo;
}
public void setContactNo(String contactNo) {
	ContactNo = contactNo;
}

  

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    @Override
    public String toString() {
        return "TeacherElements{" + "Name=" + Name + ", Address=" + Address + ", Email=" + Email + ", ContactNo=" + ContactNo + ", UserID=" + UserID + ", Position=" + Position + '}';
    }


  
}
