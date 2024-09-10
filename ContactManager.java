import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n----- Menu de Gerenciamento de Contatos -----");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1: 
                    System.out.print("Digite o nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, phone, email);
                    contactList.addContact(contact);
                    break;

                case 2:
                    System.out.print("Digite o nome ou telefone para buscar: ");
                    String searchQuery = scanner.nextLine();
                    Contact found = contactList.searchContact(searchQuery);
                    if (found != null) {
                        System.out.println("Contato encontrado:");
                        System.out.println(found);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3: 
                    System.out.print("Digite o nome ou telefone para remover: ");
                    String removeQuery = scanner.nextLine();
                    if (contactList.removeContact(removeQuery)) {
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4: 
                    System.out.println("Lista de Contatos:");
                    contactList.listContacts();
                    break;

                case 5: 
                    System.out.println("Saindo da aplicação!");
                    break;

                default:
                    System.out.println("Opção não encontrada. Tente outra opção.");
            }
        } while (option != 5);

        scanner.close();
    }
}