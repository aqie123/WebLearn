package xml;

/**
 * 联系人 id name mobile
 */
public class AddressBook {
    private String id;
    private String name;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /*
    @Override
    public String toString() {
        return "AddressBook[id="+id+",name="+name+",mobile="+mobile+"]";
    }
    */
}
