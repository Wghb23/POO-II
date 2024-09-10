public class ContactList {
    private Node head; 

    public ContactList() {
        this.head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contato adicionado!");
    }

    public Contact searchContact(String searchQuery) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(searchQuery) || 
                current.contact.getPhoneNumber().equals(searchQuery)) {
                return current.contact;
            }
            current = current.next;
        }
        return null; 
    }

    public boolean removeContact(String searchQuery) {
        if (head == null) {
            return false;
        }

        if (head.contact.getName().equalsIgnoreCase(searchQuery) || 
            head.contact.getPhoneNumber().equals(searchQuery)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.contact.getName().equalsIgnoreCase(searchQuery) || 
                current.next.contact.getPhoneNumber().equals(searchQuery)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; 
    }

    public void listContacts() {
        Node current = head;
        if (current == null) {
            System.out.println("A lista de contatos está vazia.");
            return;
        }
        while (current != null) {
            System.out.println(current.contact);
            System.out.println("---------------------------");
            current = current.next;
        }
    }
}