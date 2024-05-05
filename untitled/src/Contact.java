public class Contact {


    private String first;
    private String last;
    private String phone;
    private String email;

    public Contact(){

    }
    public Contact(String first,String last,String phone,String email){
        this.setFirst(first);
        this.setLast(last);
        this.setPhone(phone);
        this.setEmail(email);
    }


    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
