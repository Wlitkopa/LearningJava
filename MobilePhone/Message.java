public class Message {

    private Contact contact;
    private String text;

    public Message(Contact contact, String text) {
        this.contact = contact;
        this.text = text;
    }

    public Contact getContact() {
        return contact;
    }

    public String getText() {
        return text;
    }

}
