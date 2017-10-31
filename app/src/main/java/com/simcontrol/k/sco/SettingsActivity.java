package com.simcontrol.k.sco;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    Button btnsave,btnthoat,btndoimk,dbtnsave,dbtnhuy;
    TextView txtcurrent,txtmk;
    EditText edtnewnumber,edtpassword,edtmkcu,edtmkmoi,edtnhaplai;
    Dialog dialog;
    String password,CurentPhone;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        anhXa();
        handle();
        getShare();
        setTextCurrentPhone();
    }

    private void handle() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMain = new Intent(SettingsActivity.this,MainActivity.class);
                startActivity(goMain);
            }
        });
        btndoimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = sharedPreferences.getString("password","0000");
                dialogPass();
                dbtnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dbtnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String oldPass = edtmkcu.getText().toString().trim();
                        String newPass = edtmkmoi.getText().toString().trim();
                        String againPass = edtnhaplai.getText().toString().trim();

                        if(oldPass.isEmpty()){
                            dialogNote("Vui lòng nhập mật khẩu cũ");
                        }else {
                            if(oldPass.equals(password)){ //password đúng
                                if(newPass.isEmpty()){
                                    dialogNote("Vui lòng nhập mật khẩu mới!");
                                }else {
                                    if(newPass.length()<4)
                                    {
                                        dialogNote("Mật khẩu gồm 4 chữ số!");
                                    }
                                    else {
                                        if (againPass.equals(newPass)) {
                                            password = newPass;
                                            ShareEdit();
                                            editor.putString("password", newPass);
                                            editor.apply();
                                            Toast.makeText(SettingsActivity.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                                            edtmkcu.setText(null);
                                            edtmkmoi.setText(null);
                                            edtnhaplai.setText(null);
                                            dialog.dismiss();
                                        } else {
                                            dialogNote("Mật khẩu mới không khớp");
                                            edtnhaplai.setText(null);
                                        }
                                    }
                                }
                            }else {
                                dialogNote("Mật khẩu cũ không đúng!");
                                edtmkcu.setText(null);
                            }
                        }
                    }
                });
            }
        });

        txtmk.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.dialog_command);
                dialog.show();
                dialog.setCancelable(false);

                final EditText edton1 = (EditText) dialog.findViewById(R.id.edton1);
                final EditText edton2 = (EditText) dialog.findViewById(R.id.edton2);
                final EditText edtoff1 = (EditText) dialog.findViewById(R.id.edtoff1);
                final EditText edtoff2 = (EditText) dialog.findViewById(R.id.edtoff2);
                final EditText edton12 = (EditText) dialog.findViewById(R.id.edton12);
                final EditText edtoff12 = (EditText) dialog.findViewById(R.id.edtoff12);
                final EditText edtkttk = (EditText) dialog.findViewById(R.id.edtkttk);
                final EditText edtkttt = (EditText) dialog.findViewById(R.id.edtkttt);
                final EditText edtnotifoff = (EditText) dialog.findViewById(R.id.edtnotifoff);
                final EditText edtnotifon = (EditText) dialog.findViewById(R.id.edtnotifon);
                final EditText edtaddsdt = (EditText) dialog.findViewById(R.id.edtaddsdt);
                final EditText edtdoimk = (EditText) dialog.findViewById(R.id.edtdoimk);
                final EditText edtnaptien = (EditText) dialog.findViewById(R.id.edtnaptien);

                Button btnset = (Button) dialog.findViewById(R.id.btnset);
                Button btnexit = (Button) dialog.findViewById(R.id.btnexit);
                sharedPreferences = getSharedPreferences("AT",MODE_PRIVATE);
                edton1.setText(sharedPreferences.getString("cmdon1","on1"));
                edton2.setText(sharedPreferences.getString("cmdon2","on2"));
                edtoff1.setText(sharedPreferences.getString("cmdoff1","off1"));
                edtoff2.setText(sharedPreferences.getString("cmdoff2","off2"));
                edton12.setText(sharedPreferences.getString("cmdallon","on"));
                edtoff12.setText(sharedPreferences.getString("cmdalloff","off"));
                edtkttk.setText(sharedPreferences.getString("cmdkttk","kttk"));
                edtkttt.setText(sharedPreferences.getString("cmdkttt","kttt"));
                edtnotifoff.setText(sharedPreferences.getString("cmdnotifoff","thongbao off"));
                edtnotifon.setText(sharedPreferences.getString("cmdnotifon","thongbao on"));
                edtaddsdt.setText(sharedPreferences.getString("cmdaddsdt","sdt"));
                edtdoimk.setText(sharedPreferences.getString("cmddoimk","doimk"));
                edtnaptien.setText(sharedPreferences.getString("cmdnaptien","naptien"));


                btnexit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String oncmd1 = edton1.getText().toString().trim();
                        String oncmd2 = edton2.getText().toString().trim();
                        String offcmd1 = edtoff1.getText().toString().trim();
                        String offcmd2 = edtoff2.getText().toString().trim();
                        String alloncmd = edton12.getText().toString().trim();
                        String alloffcmd = edtoff12.getText().toString().trim();
                        String kttkcmd = edtkttk.getText().toString().trim();
                        String ktttcmd = edtkttt.getText().toString().trim();
                        String notifoffcmd = edtnotifoff.getText().toString().trim();
                        String notifoncmd = edtnotifon.getText().toString().trim();
                        String addsdtcmd = edtaddsdt.getText().toString().trim();
                        String doimkcmd = edtdoimk.getText().toString().trim();
                        String naptiencmd = edtnaptien.getText().toString().trim();


                        if(oncmd1.isEmpty()||oncmd2.isEmpty()||offcmd1.isEmpty()||offcmd2.isEmpty()||alloffcmd.isEmpty()||alloncmd.isEmpty()){
                            dialogNote("vui lòng không để trống!");
                        }else {
                            ShareEdit();
                            editor.putString("cmdon1",oncmd1);
                            editor.putString("cmdon2",oncmd2);
                            editor.putString("cmdoff1",offcmd1);
                            editor.putString("cmdoff2",offcmd2);
                            editor.putString("cmdallon",alloncmd);
                            editor.putString("cmdalloff",alloffcmd);
                            editor.putString("cmdkttk",kttkcmd);
                            editor.putString("cmdkttt",ktttcmd);
                            editor.putString("cmdnotifoff",notifoffcmd);
                            editor.putString("cmdnotifon",notifoncmd);
                            editor.putString("cmdaddsdt",addsdtcmd);
                            editor.putString("cmddoimk",doimkcmd);
                            editor.putString("cmdnaptien",naptiencmd);
                            editor.apply();
                            Toast.makeText(SettingsActivity.this, "Set Command success!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

                return false;
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newnumber=edtnewnumber.getText().toString().trim();
                String passInput = edtpassword.getText().toString().trim();

                if(newnumber.isEmpty()){
                    dialogNote("Vui lòng nhập sđt mới!");
                }else {
                    if (passInput.equals(password)) {
                        ShareEdit();
                        editor.putString("CurrentPhone", newnumber);
                        editor.apply();
                        getShare();
                        setTextCurrentPhone();
                        edtnewnumber.setText(null);
                        edtpassword.setText(null);
                        Toast.makeText(SettingsActivity.this, "Đổi sđt thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        edtpassword.setText(null);
                        dialogNote("Mật khẩu không đúng!");
                    }

                }
            }
        });
    btndoimk.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            dialog = new Dialog(SettingsActivity.this);
            dialog.setContentView(R.layout.dialog_rst_pass);
            dialog.show();
            dialog.setCancelable(false);

            Button btnrstok = (Button) dialog.findViewById(R.id.btnrstok);
            Button btnrsthuy = (Button) dialog.findViewById(R.id.btnrsthuy);
            final EditText edtrst = (EditText) dialog.findViewById(R.id.edtrst);

            btnrsthuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            btnrstok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String rstInput = edtrst.getText().toString().trim().toUpperCase();
                    if(rstInput.equals("CTA")){
                        password="0000";
                        ShareEdit();
                        editor.putString("password","0000");
                        editor.apply();
                        getShare();
                        Toast.makeText(SettingsActivity.this, "Reset mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else {
                        dialogNote("Mật khẩu không đúng!");
                        edtrst.setText(null);
                    }
                }
            });

            return false;
        }
    });
    }

    private void anhXa() {
        btnsave = (Button) findViewById(R.id.btnsave);
        btnthoat = (Button) findViewById(R.id.btnthoat);
        txtcurrent = (TextView) findViewById(R.id.txtcurrentnumber);
        edtnewnumber = (EditText) findViewById(R.id.edtnewnumber);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        btndoimk = (Button) findViewById(R.id.btndoimk);
        txtmk = (TextView) findViewById(R.id.txtmk);

    }

    private void ShareEdit(){
        sharedPreferences = getSharedPreferences("AT",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    private void getShare() {
        sharedPreferences = getSharedPreferences("AT", MODE_PRIVATE);
        password = sharedPreferences.getString("password","0000");
        CurentPhone = sharedPreferences.getString("CurrentPhone","");
    }
    private void dialogPass(){
        dialog = new Dialog(SettingsActivity.this);
        dialog.setContentView(R.layout.dialog_doi_mk);
        dialog.show();
        dialog.setCancelable(false);

        dbtnhuy = (Button) dialog.findViewById(R.id.btnhuy);
        dbtnsave = (Button) dialog.findViewById(R.id.btnsave);
        edtmkcu = (EditText) dialog.findViewById(R.id.edtmkcu);
        edtmkmoi = (EditText) dialog.findViewById(R.id.edtmkmoi);
        edtnhaplai = (EditText) dialog.findViewById(R.id.edtmkagain);
    }

    public void dialogNote(String note){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage(note);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void setTextCurrentPhone()
    {
        String array[]={"","*","**","***","****","*****","******","*******","********","*********"};
        int L1=CurentPhone.length()-3;
        int L2=CurentPhone.length()-2;
        int L3=CurentPhone.length()-1;
        int P= CurentPhone.length()-3;
        if(CurentPhone.length()>2) {
            txtcurrent.setText(""+array[P]+""+CurentPhone.charAt(L1)+""+CurentPhone.charAt(L2)+""+CurentPhone.charAt(L3));
        }
    }
}
