/* Viết chương trình qli các bàn <code, nsx, price>
Các chức năng
- Thêm bàn
- Xóa bàn = code
- Sửa giá
- Liệt kê
 */

package banmng;

/**
 *
 * @author SE140355
 */
public class BanMng {
    public static void main(String args[]) {
        Menu menu = new Menu("Quan Li Ban");
        menu.addNewOption("1. Them ban");
        menu.addNewOption("2. Xoa ban");
        menu.addNewOption("3. Sua gia");
        menu.addNewOption("4. Liet ke");
        menu.addNewOption("5. Thoat");
        
        DSBan ds = new DSBan();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    ds.add();
                    break;
                case 2:
                    ds.delete();
                    break;
                case 3:
                    ds.editPrice();
                    break;
                case 4:
                    ds.printAll();
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice != 5);
        
    }
    
}
