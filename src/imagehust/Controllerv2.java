/*

execute:dùng cho câu sql DDL (tạo, xóa, sửa bảng)
executeUpdate: dùng cho câu sql INSERT, UPDATE, DELETE
executeQuery: dùng câu sql SELECT

-Với những trường hợp SQL không cần truyền vào tham số thì 
sẽ sử dụng đối tượng Statement
-Với nhưng trường hợp SQL cần truyền vào tham số để filter trong việc 
select, delete, hay update thì sẽ sử dụng đối tượng PreparedStatement.


 */
package imagehust;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public final class Controllerv2 extends javax.swing.JFrame {
    
    private final Connection conn = ConnectionSQL.getConnection();
    DefaultTableModel model;
    
    public Controllerv2(String sql) throws SQLException {
        initComponents(); 
        getInfo(sql);
    }

    /**
     *
     * @param s:là tên database
     * @param condition : là hành động nó thực hiện có trả về hoặc k trả về
     * @return a string query!
     */
    
    private void getInfo(String sql) throws SQLException {
        System.out.println(sql);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (!rs.equals(null)) {
            jTableTable.setModel(DbUtils.resultSetToTableModel(rs));
            jTableTable.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "LỖI");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách");
        setBounds(new java.awt.Rectangle(2, 2, 2, 2));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setAutoscrolls(true);

        jTableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTable);
        jTableTable.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTable;
    // End of variables declaration//GEN-END:variables
}
