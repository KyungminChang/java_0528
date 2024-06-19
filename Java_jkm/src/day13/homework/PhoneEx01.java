/*package day13.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneEx01 {
		class Contact {
		    String name;
		    String phoneNumber;

		    Contact(String name, String phoneNumber) {
		        this.name = name;
		        this.phoneNumber = phoneNumber;
		    }
		}

		public class ContactManager {
		    private ArrayList<Contact> contacts = new ArrayList<>();
		    private Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) {
		        ContactManager manager = new ContactManager();
		        manager.run();
		    }

		    private void run() {
		        while (true) {
		            System.out.println("1. 연락처 추가");
		            System.out.println("2. 연락처 수정");
		            System.out.println("3. 연락처 삭제");
		            System.out.println("4. 연락처 검색");
		            System.out.println("5. 프로그램 종료");
		            System.out.print("메뉴 선택: ");

		            int choice = Integer.parseInt(scanner.nextLine());

		            switch (choice) {
		                case 1:
		                    addContact();
		                    break;
		                case 2:
		                    updateContact();
		                    break;
		                case 3:
		                    deleteContact();
		                    break;
		                case 4:
		                    searchContact();
		                    break;
		                case 5:
		                    System.out.println("프로그램을 종료합니다.");
		                    return;
		                default:
		                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
		            }
		        }
		    }

		    private void addContact() {
		        System.out.println("--------------");
		        System.out.print("이름: ");
		        String name = scanner.nextLine();
		        System.out.print("번호: ");
		        String phoneNumber = scanner.nextLine();

		        if (isPhoneNumberExists(phoneNumber)) {
		            System.out.println("--------------");
		            System.out.println("이미 등록된 번호입니다.");
		        } else {
		            contacts.add(new Contact(name, phoneNumber));
		            System.out.println("--------------");
		            System.out.println("등록이 완료됐습니다.");
		        }
		    }

		    private void updateContact() {
		        System.out.println("--------------");
		        System.out.print("이름: ");
		        String name = scanner.nextLine();

		        ArrayList<Contact> matchingContacts = new ArrayList<>();
		        for (Contact contact : contacts) {
		            if (contact.name.contains(name)) {
		                matchingContacts.add(contact);
		            }
		        }

		        if (matchingContacts.isEmpty()) {
		            System.out.println("해당 이름의 연락처가 없습니다.");
		            return;
		        }

		        for (int i = 0; i < matchingContacts.size(); i++) {
		            Contact contact = matchingContacts.get(i);
		            System.out.println((i + 1) + ". " + contact.name + " : " + contact.phoneNumber);
		        }

		        System.out.print("번호 선택: ");
		        int index = Integer.parseInt(scanner.nextLine()) - 1;

		        if (index < 0 || index >= matchingContacts.size()) {
		            System.out.println("잘못된 선택입니다.");
		            return;
		        }

		        Contact selectedContact = matchingContacts.get(index);
		        System.out.print("이름: ");
		        String newName = scanner.nextLine();
		        System.out.print("번호: ");
		        String newPhoneNumber = scanner.nextLine();

		        if (isPhoneNumberExists(newPhoneNumber) && !selectedContact.phoneNumber.equals(newPhoneNumber)) {
		            System.out.println("--------------");
		            System.out.println("이미 등록된 번호입니다.");
		        } else {
		            selectedContact.name = newName;
		            selectedContact.phoneNumber = newPhoneNumber;
		            System.out.println("--------------");
		            System.out.println("수정이 완료됐습니다.");
		        }
		    }

		    private void deleteContact() {
		        System.out.println("--------------");
		        System.out.print("이름: ");
		        String name = scanner.nextLine();

		        ArrayList<Contact> matchingContacts = new ArrayList<>();
		        for (Contact contact : contacts) {
		            if (contact.name.contains(name)) {
		                matchingContacts.add(contact);
		            }
		        }

		        if (matchingContacts.isEmpty()) {
		            System.out.println("해당 이름의 연락처가 없습니다.");
		            return;
		        }

		        for (int i = 0; i < matchingContacts.size(); i++) {
		            Contact contact = matchingContacts.get(i);
		            System.out.println((i + 1) + ". " + contact.name + " : " + contact.phoneNumber);
		        }

		        System.out.print("삭제할 번호 선택: ");
		        int index = Integer.parseInt(scanner.nextLine()) - 1;

		        if (index < 0 || index >= matchingContacts.size()) {
		            System.out.println("잘못된 선택입니다.");
		            return;
		        }

		        contacts.remove(matchingContacts.get(index));
		        System.out.println("--------------");
		        System.out.println("삭제가 완료됐습니다.");
		    }

		    private void searchContact() {
		        System.out.println("--------------");
		        System.out.print("검색할 이름을 작성하세요(전체 검색: 엔터): ");
		        String name = scanner.nextLine();

		        for (int i = 0; i < contacts.size(); i++) {
		            Contact contact = contacts.get(i);
		            if (contact.name.contains(name)) {
		                System.out.println((i + 1) + ". " + contact.name + " : " + contact.phoneNumber);
		            }
		        }
		    }

		    private boolean isPhoneNumberExists(String phoneNumber) {
		        for (Contact contact : contacts) {
		            if (contact.phoneNumber.equals(phoneNumber)) {
		                return true;
		            }
		        }
		        return false;
		    }
		}

		

	}*/

