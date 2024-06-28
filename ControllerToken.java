package Controller;

import Model.Token;
import Model.TokenDAO;
import View.TokenForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControllerToken implements ActionListener {

    TokenDAO dao1 = new TokenDAO();
    Token ap1 = new Token();
    TokenForm form;

    public ControllerToken(TokenForm fl) {
        this.form = fl;
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
            List(form.tblToken);
            Clean();

        }
        if (e.getSource() == form.btnSave) {
            Save();
            List(form.tblToken);
            Clean();

        }
        if (e.getSource() == form.btnView) {
            int rows = form.tblToken.getSelectedRow();
            if (rows == -1) {
                form.txtMessage.setText("Select a row");

            } else {
                int id = Integer.parseInt(form.tblToken.getValueAt(rows, 0).toString());
                int IdApprentice = Integer.parseInt(form.tblToken.getValueAt(rows, 1).toString());
                String NumberFile = form.tblToken.getValueAt(rows, 2).toString();
                String NameFile = form.tblToken.getValueAt(rows, 3).toString();
                String campus = form.tblToken.getValueAt(rows, 4).toString();
                String City = form.tblToken.getValueAt(rows, 5).toString();

                form.txtidToken.setText(String.valueOf(id));
                form.txtidApprentice.setText(String.valueOf(IdApprentice));
                form.txtNumToken.setText(NumberFile);
                form.txtNameProg.setText(NameFile);
                form.cbxSite.setSelectedItem(campus);
                form.txtCity.setText(City);
            }

        }
        if (e.getSource() == form.btnUpdate) {
            Update();
            List(form.tblToken);
            Clean();
        }

        if (e.getSource() == form.btnDelete) {
            Delete();
            List(form.tblToken);
            Clean();
        }

        if (e.getSource() == form.btnExit) {
            int confirm = JOptionPane.showConfirmDialog(null, "Exit the program", "Message", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }

    }

    public void List(JTable tblToken) {
        CenterTable(tblToken);
        DefaultTableModel model = (DefaultTableModel) form.tblToken.getModel();
        model.setRowCount(0);
        List<Token> listt = dao1.List();
        for (Token learn : listt) {
            Object[] object = {learn.getId(), learn.getIdAppren(), learn.getNumTok(), learn.getNameprog(), learn.getSite(), learn.getCity()};
            model.addRow(object);
        }
        tblToken.setModel(model);
    }

    public void Save() {
        int idApprentice = Integer.parseInt(form.txtidApprentice.getText());
        int numberTok = Integer.parseInt(form.txtNumToken.getText());
        String nameProg = form.txtNameProg.getText();
        String site = form.cbxSite.getSelectedItem().toString();
        String city = form.txtCity.getText();

        Token Fil = new Token();
        Fil.setIdAppren(idApprentice);
        Fil.setNumTok(numberTok);
        Fil.setNameprog(nameProg);
        Fil.setSite(site);
        Fil.setCity(city);

        int r = dao1.Add(Fil);
        if (r == 1) {
            form.txtMessage.setText("Token successfuly added");

        } else {
           
        }

    }

    public void Update() {
        if (form.txtidToken.getText().equals("")) {
            form.txtMessage.setText("Id not found");

        } else {
            int id = Integer.parseInt(form.txtidToken.getText());
            int idApre = Integer.parseInt(form.txtidApprentice.getText());
            int numTok = Integer.parseInt(form.txtNumToken.getText());
            String nameProg = form.txtNameProg.getText();
            String site = form.cbxSite.getSelectedItem().toString();
            String city = form.txtCity.getText();

            ap1.setId(id);
            ap1.setIdAppren(idApre);
            ap1.setNumTok(numTok);
            ap1.setNameprog(nameProg);
            ap1.setSite(site);
            ap1.setCity(city);

            int r = dao1.Update(ap1);
            if (r == 1) {
                form.txtMessage.setText("Token successfuly update");

            } else {
             
            }
        }

    }

    public void Delete() {
        int rows = form.tblToken.getSelectedRow();
        if (rows == -1) {
            form.txtMessage.setText("select a row");

        } else {
            int id = Integer.parseInt(form.tblToken.getValueAt(rows, 0).toString());
            dao1.Delete(id);

        }
        CleanTable();
    }

    public void CenterTable(JTable tblfile) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < form.tblToken.getColumnCount(); i++) {
            tblfile.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void CleanTable() {
        DefaultTableModel model = (DefaultTableModel) form.tblToken.getModel();
        model.setRowCount(0);
    }

    public void Clean() {
        form.txtidToken.setText("");
        form.txtNumToken.setText("");
        form.txtNameProg.setText("");
        form.cbxSite.setSelectedIndex(0);
        form.txtCity.setText("");

    }

}
