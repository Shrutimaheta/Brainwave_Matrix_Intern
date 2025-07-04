
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Bill_RoomRec extends javax.swing.JFrame {
    Connection con=null;    
    ResultSet rs=null;
    PreparedStatement pst=null;

    public Bill_RoomRec() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }
    private void Get_Data(){
         try{
                String sql="Select BillNo as 'Bill No.',PatientRegistration.PatientID as 'Patient ID',PatientRegistration.PatientName as 'Patient Name',PatientRegistration.Gen as 'Gender',PatientRegistration.BG as 'Blood Group',Disease,AdmitDate as 'Admit Date',Room.RoomNo as 'Room No',Doctor.DoctorID as 'Doctor ID',DoctorName as 'Doctor Name',DischargeDate as 'Discharge Date',Bill_Room.RoomCharges as 'Room Charges',Bill_Room.ServiceCharges as 'Service Charges',Bill_Room.BillingDate as 'Billing Date',PaymentMode as 'Payement Mode',PaymentModeDetails as 'Payment Mode Details',TotalCharges as 'Total Charges',NoOfDays as 'No. Of Days',TotalRoomCharges as 'Total Room Charges' from Room,Doctor,PatientRegistration,AdmitPatient_Room,DischargePatient_Room,Bill_Room where Room.RoomNo=AdmitPatient_Room.RoomNo and Doctor.DoctorID=AdmitPatient_Room.DoctorID and PatientRegistration.PatientID=AdmitPatient_Room.PatientID  and AdmitPatient_Room.PatientID= DischargePatient_Room.admitID and Bill_Room.DischargeID=DischargePatient_Room.AdmitID  order by Billingdate"; 
                pst=con.prepareStatement(sql);
                rs= pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            this.hide();
            Bill_Room frm = new Bill_Room();
            frm.setVisible(true);
            String add= jTable1.getModel().getValueAt(row, 0).toString();
            frm.txtBillNo.setText(add);
             String add3= jTable1.getModel().getValueAt(row, 1).toString();
            frm.PatientID.setText(add3);
              String add4= jTable1.getModel().getValueAt(row, 2).toString();
            frm.txtPatientName.setText(add4);
              String add5= jTable1.getModel().getValueAt(row, 3).toString();
            frm.txtGender.setText(add5);
              String add6= jTable1.getModel().getValueAt(row, 4).toString();
            frm.txtBloodGroup.setText(add6);
              String add7= jTable1.getModel().getValueAt(row, 5).toString();
            frm.txtDisease.setText(add7);
              String add8= jTable1.getModel().getValueAt(row, 6).toString();
            frm.txtAdmitDate.setText(add8);
              String add9= jTable1.getModel().getValueAt(row, 7).toString();
            frm.txtRoomNo.setText(add9);
              String add10= jTable1.getModel().getValueAt(row, 8).toString();
            frm.txtDoctorID.setText(add10);
              String add11= jTable1.getModel().getValueAt(row, 9).toString();
            frm.txtDoctorName.setText(add11);
              String add12= jTable1.getModel().getValueAt(row, 10).toString();
            frm.txtDischargeDate.setText(add12);
              String add13= jTable1.getModel().getValueAt(row, 11).toString();
            frm.txtRoomCharges.setText(add13);
              String add14= jTable1.getModel().getValueAt(row, 12).toString();
            frm.txtServiceCharges.setText(add14);
              String add15= jTable1.getModel().getValueAt(row, 13).toString();
            frm.txtBillingDate.setText(add15);
              String add16= jTable1.getModel().getValueAt(row, 14).toString();
            frm.cmbPaymentMode.setSelectedItem(add16);
              String add17= jTable1.getModel().getValueAt(row, 15).toString();
            frm.txtPaymentModeDetails.setText(add17);
             String add18= jTable1.getModel().getValueAt(row, 16).toString();
            frm.txtTotalCharges.setText(add18);
             String add21= jTable1.getModel().getValueAt(row, 17).toString();
            frm.txtNoOfDays.setText(add21);
             String add22= jTable1.getModel().getValueAt(row, 18).toString();
            frm.txtTotalRoomCharges.setText(add22);
            frm.PatientID.setText(add3);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);
          }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill_RoomRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
