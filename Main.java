import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Покупатель> customersArray = new ArrayList<>();

        ArrayList<String> Бренд = new ArrayList<>();
        Бренд.add("Гуччи");
        Бренд.add("Адидас");
        Бренд.add("Найк");

        ArrayList<String[]> Товар = new ArrayList<>();
        Товар.add(new String[]{"Гуччи", "Алмазные"});
        Товар.add(new String[]{"Адидас", "Три полоски"});
        Товар.add(new String[]{"Адидас", "Раша стайл"});
        Товар.add(new String[]{"Найк", "Хайповые"});

        for (int i = 1; i <= 3; i++)
        {
            System.out.println("Введите данные для заказа " + i);

            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Номер телефона: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Список позиций (Товар - Фирма):");
            for (int j = 0; j < Товар.size(); j++)
            {
                String[] position = Товар.get(j);
                System.out.println(j + 1 + ". " + position[0] + " - " + position[1]);
            }
            System.out.print("Выберите позицию: ");
            int positionIndex = Integer.parseInt(scanner.nextLine()) - 1;
            String[] selectedPosition = Товар.get(positionIndex);

            System.out.print("Количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Покупатель покупатель = new Покупатель(fullName, email, phoneNumber, selectedPosition, quantity);
            customersArray.add(покупатель);
        }

        for (int i = 0; i < customersArray.size(); i++)
        {
            Покупатель customer = customersArray.get(i);
            String[] position = customer.getProduct();

            System.out.println("\nЗаказчик " + (i + 1) + ":");
            System.out.println("ФИО: " + customer.getFullName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Номер телефона: " + customer.getPhoneNumber());
            System.out.println("Позиция: " + position[0] + " - " + position[1]);
            System.out.println("Количество: " + customer.getQuantity());
        }
    }
}

class Покупатель
{
    private String fullName;
    private String email;
    private String phoneNumber;
    private String[] product;
    private int quantity;

    public Покупатель(String fullName, String email, String phoneNumber, String[] product, int quantity)
    {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String[] getProduct()
    {
        return product;
    }

    public int getQuantity()
    {
        return quantity;
    }
}