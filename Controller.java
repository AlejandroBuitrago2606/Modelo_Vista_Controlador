package Controller;

import Model.Apprentice;
import Model.ApprenticeDAO;
import View.ApprenticeForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener {
    
    ApprenticeDAO dao = new ApprenticeDAO();
    Apprentice ap = new Apprentice();
    ApprenticeForm form;
    
    public Controller(ApprenticeForm f) {
        this.form = f;
        this.form.btnList.addActionListener(this);
        this.form.btnSave.addActionListener(this);
        this.form.btnView.addActionListener(this);
        this.form.btnDelete.addActionListener(this);
        this.form.btnUpdate.addActionListener(this);
        this.form.btnExit.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form.btnList) {
            CleanTable();
            List(form.tblapprentice);
            Clean();
            
        }
        if (e.getSource() == form.btnSave) {
            Save();
            List(form.tblapprentice);
            Clean();
            
        }
        if (e.getSource() == form.btnView) {
            int rows = form.tblapprentice.getSelectedRow();
            if (rows == -1) {
                JOptionPane.showMessageDialog(form, "Please select a row");
                
            } else {
                int id = Integer.parseInt(form.tblapprentice.getValueAt(rows, 0).toString());
                String DocumentType = form.tblapprentice.getValueAt(rows, 1).toString();
                String DocumentNumber = form.tblapprentice.getValueAt(rows, 2).toString();
                String name = form.tblapprentice.getValueAt(rows, 3).toString();
                String BirthDate = form.tblapprentice.getValueAt(rows, 4).toString();
                String Gender = form.tblapprentice.getValueAt(rows, 5).toString();
                String City = form.tblapprentice.getValueAt(rows, 6).toString();
                form.txtid.setText(String.valueOf(id));
                form.cbxTypeDoc.setSelectedItem(DocumentType);
                form.txtNumDoc.setText(DocumentNumber);
                form.txtName.setText(name);
                form.jdcbirthdate.setDate(java.sql.Date.valueOf(BirthDate));
                if (Gender.equalsIgnoreCase("Male")) {
                    form.rbmale.setSelected(true);
                    
                } else if (Gender.equalsIgnoreCase("Female")) {
                    form.rbfemale.setSelected(true);
                }
                
                form.txtCity.setText(City);
                
            }
        }
        if (e.getSource() == form.btnUpdate) {
            Update();
            List(form.tblapprentice);
            Clean();
        }
        
        if (e.getSource() == form.btnDelete) {
            Delete();
            List(form.tblapprentice);
            Clean();
        }
        
        if (e.getSource() == form.btnExit) {
            int confirm = JOptionPane.showConfirmDialog(null, "Exit the program", "Message", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
        
    }
    
    public void List(JTable tblApren) {
        CenterTable(tblApren);
        DefaultTableModel model = (DefaultTableModel) form.tblapprentice.getModel();
        model.setRowCount(0);
        List<Apprentice> listt = dao.List();
        for (Apprentice learn : listt) {
            Object[] object = {learn.getId(), learn.getDoctype(), learn.getDocNumber(), learn.getName(), learn.getBirthDate(), learn.getGender(), learn.getCity()};
            model.addRow(object);
        }
        tblApren.setModel(model);
        form.txtMessage.setText("Apprentice´s shown correctly");
    }
    
    public void Save() {
        
        int id = Integer.parseInt(form.txtid.getText());
        String type = form.cbxTypeDoc.getSelectedItem().toString();
        String docNum = form.txtNumDoc.getText();
        String name = form.txtName.getText();
        java.util.Date dateBorn = form.jdcbirthdate.getDate();
        String gender = form.rbmale.isSelected() ? "Male" : "Female";
        String city = form.txtCity.getText();
        
        Apprentice apre = new Apprentice();
        apre.setId(id);
        apre.setDoctype(type);
        apre.setDocNumber(docNum);
        apre.setName(name);
        apre.setBirthDate(dateBorn);
        apre.setGender(gender);
        apre.setCity(city);
        
       
        int r = dao.Add(apre);
        if (r == 1) {
            form.txtMessage.setText("Apprentice Successfuly Saved");
            
        } else {
            
        }
        
    }
    
    public void Update() {
        if (form.txtid.getText().equals("")) {
            form.txtMessage.setText("Id not found");
            
        } else {
            int id = Integer.parseInt(form.txtid.getText());
            
            String Documenttype = form.cbxTypeDoc.getSelectedItem().toString();
            String Documentnumber = form.txtNumDoc.getText();
            String name = form.txtName.getText();
            java.util.Date Birthdate = form.jdcbirthdate.getDate();
            String gender = form.rbmale.isSelected() ? "male" : "female";
            String city = form.txtCity.getText();
            
            ap.setId(id);
            ap.setDoctype(Documenttype);
            ap.setDocNumber(Documentnumber);
            ap.setName(name);
            ap.setBirthDate(Birthdate);
            ap.setGender(gender);
            ap.setCity(city);
            
            int r = dao.Update(ap);
            if (r == 1) {
                form.txtMessage.setText("Apprentice Successfully Update");
                
            } else {
                
            }
            
        }
        
    }
    
    public void Delete() {
        int rows = form.tblapprentice.getSelectedRow();
        if (rows == -1) {
            form.txtMessage.setText("Please select a row");
            
        } else {
            int id = Integer.parseInt(form.tblapprentice.getValueAt(rows, 0).toString());
            dao.Delete(id);
            form.txtMessage.setText("Apprentice Successfully Delete");
        }
        CleanTable();
    }
    
    public void CenterTable(JTable tblApren) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < form.tblapprentice.getColumnCount(); i++) {
            tblApren.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
    
    void CleanTable() {
        DefaultTableModel model = (DefaultTableModel) form.tblapprentice.getModel();
        model.setRowCount(0);
    }
    
    public void Clean() {
        form.txtid.setText("");
        form.cbxTypeDoc.setSelectedIndex(0);
        form.txtNumDoc.setText("");
        form.txtName.setText("");
        form.jdcbirthdate.setDate(null);
        form.rbmale.setSelected(false);
        form.rbfemale.setSelected(false);
        form.txtCity.setText("");
        
    }
    
}
