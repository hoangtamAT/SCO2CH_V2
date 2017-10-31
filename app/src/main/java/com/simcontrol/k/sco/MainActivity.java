package com.simcontrol.k.sco;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean tb1Stt=false,tb2Stt=false;
    Boolean sent=false;
    TextView txttb1,txttb2,txttitle,txtinfo,txtaddress,txtphone;
    Button btnon1,btnon2,btnoff1,btnoff2,btnonall,btnoffall,btnok,btncancle,btnnap,btnmathehuy,btnaddok,btnaddhuy;
    EditText edtrename,edtmathe,edtaddsdt;
    RadioButton rdb1,rdb2,rdb3;
    ProgressBar pb1, pb2;
    Dialog dialog;
    int save1,save2;
    int numPos;
    String title;
    String info,password;
    String address;
    String phoneinfo;
    public static String phoneNumber,on1,on2,off1,off2,onall,offall,kttt,kttk,notifon,notifoff,addsdt,doimk,naptien;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FloatingActionButton fabmn,fabex;
    //TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        getShare();
        setStatus();
        CheckPermission();
        HandleButton();
    }

    private void CheckPermission() {
        //check  SMS Permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                    0);
        }
    }

    private void HandleButton() {

        btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checksdt()) {
                    btnon1.setEnabled(false);
                    btnoff1.setEnabled(false);
                    btnoff2.setEnabled(false);
                    btnon2.setEnabled(false);
                    btnonall.setEnabled(false);
                    btnoffall.setEnabled(false);
                    pb1.setVisibility(View.VISIBLE);
                    sendSMS(phoneNumber, on1+".");

                        //txttb1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
                        txttb1.setBackgroundResource(R.drawable.round_txt_green);
                        ShareEdit();
                        editor.putInt("save1", 1);
                        editor.apply();

                } else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checksdt()) {
                    btnon1.setEnabled(false);
                    btnoff1.setEnabled(false);
                    btnoff2.setEnabled(false);
                    btnon2.setEnabled(false);
                    btnonall.setEnabled(false);
                    btnoffall.setEnabled(false);
                    pb1.setVisibility(View.VISIBLE);
                    sendSMS(phoneNumber, off1+".");
                        //txttb1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(209, 211, 209)));
                        txttb1.setBackgroundResource(R.drawable.roundtxt);
                        ShareEdit();
                        editor.putInt("save1", 0);
                        editor.apply();
                }else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        btnon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checksdt()) {
                    btnon1.setEnabled(false);
                    btnoff1.setEnabled(false);
                    btnoff2.setEnabled(false);
                    btnon2.setEnabled(false);
                    btnonall.setEnabled(false);
                    btnoffall.setEnabled(false);
                    pb2.setVisibility(View.VISIBLE);
                    sendSMS(phoneNumber, on2+".");

                        //txttb2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
                        txttb2.setBackgroundResource(R.drawable.round_txt_green);
                        ShareEdit();
                        editor.putInt("save2", 1);
                        editor.apply();

                }else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        btnoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checksdt()) {
                    btnon1.setEnabled(false);
                    btnoff1.setEnabled(false);
                    btnoff2.setEnabled(false);
                    btnon2.setEnabled(false);
                    btnonall.setEnabled(false);
                    btnoffall.setEnabled(false);
                    pb2.setVisibility(View.VISIBLE);
                    sendSMS(phoneNumber, off2+".");

                        //txttb2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(209, 211, 209)));
                        txttb2.setBackgroundResource(R.drawable.roundtxt);
                        ShareEdit();
                        editor.putInt("save2", 0);
                        editor.apply();


                }else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        btnonall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checksdt()) {
                    btnon1.setEnabled(false);
                    btnoff1.setEnabled(false);
                    btnoff2.setEnabled(false);
                    btnon2.setEnabled(false);
                    btnonall.setEnabled(false);
                    btnoffall.setEnabled(false);
                    pb1.setVisibility(View.VISIBLE);
                    pb2.setVisibility(View.VISIBLE);
                    sendSMS(phoneNumber, onall+".");

                        //txttb1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
                        //txttb2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
                        txttb1.setBackgroundResource(R.drawable.round_txt_green);
                        txttb2.setBackgroundResource(R.drawable.round_txt_green);
                        ShareEdit();
                        editor.putInt("save1", 1);
                        editor.putInt("save2", 1);
                        editor.apply();


                }else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        btnoffall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(checksdt()) {
                   btnon1.setEnabled(false);
                   btnoff1.setEnabled(false);
                   btnoff2.setEnabled(false);
                   btnon2.setEnabled(false);
                   btnonall.setEnabled(false);
                   btnoffall.setEnabled(false);
                   pb1.setVisibility(View.VISIBLE);
                   pb2.setVisibility(View.VISIBLE);
                   sendSMS(phoneNumber, offall+".");

                       //txttb1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(209, 211, 209)));
                       //txttb2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(209, 211, 209)));
                       txttb1.setBackgroundResource(R.drawable.roundtxt);
                       txttb2.setBackgroundResource(R.drawable.roundtxt);
                       ShareEdit();
                       editor.putInt("save1", 0);
                       editor.putInt("save2", 0);
                       editor.apply();


               }else showAlertDialog("Thông báo","Bạn chưa thêm sđt cần gửi!");
            }
        });
        fabmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });
        fabex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuEx();
            }
        });

        txttitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDialog();
                edtrename.setText(title);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txttitle.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("title",edtrename.getText().toString().trim());
                        editor.apply();
                        getShare();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });
        txtinfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDialog();
                edtrename.setText(info);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtinfo.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("info",edtrename.getText().toString().trim());
                        editor.apply();
                        getShare();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });
        txtaddress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDialog();
                edtrename.setText(address);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtaddress.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("address",edtrename.getText().toString().trim());
                        editor.apply();
                        getShare();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });
        txtphone.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDialog();
                edtrename.setText(phoneinfo);
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtphone.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("phoneinfo",edtrename.getText().toString().trim());
                        editor.apply();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });
        txttb1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                showDialog();
                edtrename.setText(sharedPreferences.getString("Nametb1","TB1"));
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txttb1.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("Nametb1",edtrename.getText().toString().trim());
                        editor.apply();
                        getShare();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });
        txttb2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                showDialog();
                edtrename.setText(sharedPreferences.getString("Nametb2","TB2"));
                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txttb2.setText(edtrename.getText().toString().trim());
                        ShareEdit();
                        editor.putString("Nametb2",edtrename.getText().toString().trim());
                        editor.apply();
                        getShare();
                        dialog.dismiss();
                    }
                });
                btncancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });


    }

    private void AnhXa() {
        txttb1 =(TextView) findViewById(R.id.txttb1);
        txttb2 = (TextView) findViewById(R.id.txttb2);
        txttitle= (TextView) findViewById(R.id.txttitle);
        txtinfo= (TextView) findViewById(R.id.txtinfo);
        txtaddress= (TextView) findViewById(R.id.txtaddress);
        txtphone= (TextView) findViewById(R.id.txtphonenumber);

        btnoff1= (Button) findViewById(R.id.btnoff1);
        btnoff2= (Button) findViewById(R.id.btnoff2);
        btnon1= (Button) findViewById(R.id.btnon1);
        btnon2= (Button) findViewById(R.id.btnon2);
        btnonall = (Button) findViewById(R.id.btnonall);
        btnoffall = (Button) findViewById(R.id.btnoffall);

        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);

        fabmn = (FloatingActionButton) findViewById(R.id.fabmn);
        fabex = (FloatingActionButton) findViewById(R.id.fabex);

    }

    public void sendSMS(String phoneNumber, String message)
    {
        String SENT			= "SMS_SENT";
        String DELIVERED	= "SMS_DELIVERED";

        PendingIntent sentPI		= PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
        PendingIntent deliveredPI	= PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        // SMS sent
                        //sent=true;
                        //Toast.makeText(MainActivity.this, "sent!", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        // SMS fail without reason
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        ShareEdit();
                        editor.putInt("save1", save1);
                        editor.putInt("save2",save2);
                        editor.apply();
                        setStatus();
                        showAlertDialog("Thông báo","Gửi thất bại");
                        //Toast.makeText(MainActivity.this, "sent fail", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        // No service
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        ShareEdit();
                        editor.putInt("save1", save1);
                        editor.putInt("save2",save2);
                        editor.apply();
                        setStatus();
                        showAlertDialog("Thông báo","Gửi thất bại");
                        //Toast.makeText(MainActivity.this, "No service", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        // Null PDU
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        ShareEdit();
                        editor.putInt("save1", save1);
                        editor.putInt("save2",save2);
                        editor.apply();
                        setStatus();
                        showAlertDialog("Thông báo","Gửi thất bại");
                        //Toast.makeText(MainActivity.this, "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        // Radio off
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        ShareEdit();
                        editor.putInt("save1", save1);
                        editor.putInt("save2",save2);
                        editor.apply();
                        setStatus();
                        showAlertDialog("Thông báo","Gửi thất bại");
                        //Toast.makeText(MainActivity.this, "Radio off", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        // SMS delivered"
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        Toast.makeText(MainActivity.this, "Gửi thành công!", Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        // SMS not delivered
                        pb1.setVisibility(View.INVISIBLE);
                        pb2.setVisibility(View.INVISIBLE);
                        btnoff1.setEnabled(true);
                        btnoff2.setEnabled(true);
                        btnon1.setEnabled(true);
                        btnon2.setEnabled(true);
                        btnoffall.setEnabled(true);
                        btnonall.setEnabled(true);
                        ShareEdit();
                        editor.putInt("save1", save1);
                        editor.putInt("save2",save2);
                        editor.apply();
                        setStatus();
                        showAlertDialog("Thông báo","Gửi thất bại");
                        //Toast.makeText(MainActivity.this, "Not delivered", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null,"#" + password + " " + message, sentPI, deliveredPI);
    }
    private void showDialog()
    {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_rename);
        dialog.show();
        dialog.setCancelable(false);

        edtrename = (EditText) dialog.findViewById(R.id.edtrename);
        btnok = (Button) dialog.findViewById(R.id.btnok);
        btncancle = (Button) dialog.findViewById(R.id.btncancle);
    }

    private void setStatus()
    {
        sharedPreferences = getSharedPreferences("AT", MODE_PRIVATE);
        save1 = sharedPreferences.getInt("save1",0);
        save2 = sharedPreferences.getInt("save2",0);
        //if(save1==1) txttb1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
        //if(save2==1) txttb2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(19, 244, 12)));
        if(save1==1) txttb1.setBackgroundResource(R.drawable.round_txt_green);
        else  txttb1.setBackgroundResource(R.drawable.roundtxt);
        if(save2==1) txttb2.setBackgroundResource(R.drawable.round_txt_green);
        else txttb2.setBackgroundResource(R.drawable.roundtxt);

    }
    private boolean checksdt()
    {
        if(phoneNumber.isEmpty())
        {
            return false;
        }else return true;
    }

        public void showAlertDialog(String note,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(note);
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    private void ShareEdit(){
        sharedPreferences = getSharedPreferences("AT",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void getShare() {
        sharedPreferences = getSharedPreferences("AT", MODE_PRIVATE);
        txttb1.setText(sharedPreferences.getString("Nametb1","TB1"));
        txttb2.setText(sharedPreferences.getString("Nametb2","TB2"));
        phoneNumber = sharedPreferences.getString("CurrentPhone","");
        password = sharedPreferences.getString("password","0000");
        on1 = sharedPreferences.getString("cmdon1","ON1");
        on2 = sharedPreferences.getString("cmdon2","ON2");
        off1 = sharedPreferences.getString("cmdoff1","OFF1");
        off2 = sharedPreferences.getString("cmdoff2","OFF2");
        onall = sharedPreferences.getString("cmdallon","ON");
        offall = sharedPreferences.getString("cmdalloff","OFF");
        kttk = sharedPreferences.getString("cmdkttk","kttk");
        kttt = sharedPreferences.getString("cmdkttt","kttt");
        notifoff = sharedPreferences.getString("cmdnotifoff","thongbao off");
        notifon = sharedPreferences.getString("cmdnotifon","thongbao on");
        addsdt = sharedPreferences.getString("cmdaddsdt","sdt");
        doimk = sharedPreferences.getString("cmddoimk","doimk");
        naptien = sharedPreferences.getString("cmdnaptien","naptien");

        save1 = sharedPreferences.getInt("save1",0);
        save2 = sharedPreferences.getInt("save2",0);

        title = sharedPreferences.getString("title","TÊN VƯỜN,DỰ ÁN");
        info = sharedPreferences.getString("info","thông tin, giới thiệu, tiêu chí");
        address = sharedPreferences.getString("address","Địa chỉ: 123 đường XYZ, phường ABC, Tp. TTT");
        phoneinfo = sharedPreferences.getString("phoneinfo","Điện thoại: 0123 456 789");
        txttitle.setText(title);
        txtinfo.setText(info);
        txtaddress.setText(address);
        txtphone.setText(phoneinfo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnsettings:
                Intent gost = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(gost);
                break;
            case R.id.mninfo:
                Intent goinfo = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(goinfo);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showMenu()
    {
        PopupMenu popupMenu = new PopupMenu(this,fabmn);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.mnsettings:
                        Intent gosetting = new Intent(MainActivity.this,SettingsActivity.class);
                        startActivity(gosetting);
                        break;
                    case R.id.mninfo:
                        Intent goAbout = new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(goAbout);
                        break;
                }

                return false;
            }
        });
        popupMenu.show();



    }
    private void showMenuEx() {
        PopupMenu popupMenuEx = new PopupMenu(this, fabex);
        popupMenuEx.getMenuInflater().inflate(R.menu.extension_menu, popupMenuEx.getMenu());
        popupMenuEx.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mnkttk:
                        sendSMS(phoneNumber, kttk + ".");
                        Toast.makeText(MainActivity.this, "Đã gửi, vui lòng kiểm tra Sms đến", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnkttt:
                        sendSMS(phoneNumber, kttt + ".");
                        Toast.makeText(MainActivity.this, "Đã gửi, vui lòng kiểm tra Sms đến", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnNaptien:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog_naptien);
                        dialog.show();
                        dialog.setCancelable(false);

                        edtmathe = (EditText) dialog.findViewById(R.id.edtmathe);
                        btnnap = (Button) dialog.findViewById(R.id.btnnapthe);
                        btnmathehuy = (Button) dialog.findViewById(R.id.btnnapthehuy);
                        btnmathehuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        btnnap.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String mathecao = edtmathe.getText().toString().trim();
                                if (mathecao.length() < 13) {
                                    showAlertDialog("Thông báo", "Mã thẻ cào gồm 13 chữ số");
                                } else {
                                    sendSMS(phoneNumber, naptien + " " + mathecao + ".");
                                    Toast.makeText(MainActivity.this, "Đã nạp thẻ, vui lòng kiểm tra Sms đến", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            }
                        });

                        break;
                    case R.id.mnaddsdt:
                        addNumberPhone();
                        break;
                    case R.id.mntattb:
                        Toast.makeText(MainActivity.this, "Đã gửi, vui lòng kiểm tra Sms đến", Toast.LENGTH_SHORT).show();
                        sendSMS(phoneNumber, notifoff + ".");
                        break;
                    case R.id.mnbattb:
                        Toast.makeText(MainActivity.this, "Đã gửi, vui lòng kiểm tra Sms đến", Toast.LENGTH_SHORT).show();
                        sendSMS(phoneNumber, notifon + ".");
                        break;
                }

                return false;
            }
        });
        popupMenuEx.show();
        }
        private void addNumberPhone()
        {
            dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.dialog_add_sdt);
            dialog.show();
            dialog.setCancelable(false);


            edtaddsdt = (EditText) dialog.findViewById(R.id.edtaddsdt);
            btnaddok = (Button) dialog.findViewById(R.id.btnaddsdtthem);
            btnaddhuy = (Button) dialog.findViewById(R.id.btnaddsdthuy);
            rdb1 = (RadioButton) dialog.findViewById(R.id.rdbsdt1);
            rdb2 = (RadioButton) dialog.findViewById(R.id.rdbsdt2);
            rdb3 = (RadioButton) dialog.findViewById(R.id.rdbsdt3);


            rdb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rdb1.setChecked(true);
                    rdb2.setChecked(false);
                    rdb3.setChecked(false);
                    numPos=1;
                }
            });
            rdb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rdb1.setChecked(false);
                    rdb2.setChecked(true);
                    rdb3.setChecked(false);
                    numPos=2;
                }
            });
            rdb3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rdb1.setChecked(false);
                    rdb2.setChecked(false);
                    rdb3.setChecked(true);
                    numPos=3;
                }
            });

            btnaddhuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            btnaddok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String numberAdd = edtaddsdt.getText().toString().trim();
                    if(rdb1.isChecked()||rdb2.isChecked()||rdb3.isChecked())
                    {
                        if(numberAdd.length()<10)
                        {
                            showAlertDialog("Thông báo","Kiểm tra lại sđt");
                        }else {
                            sendSMS(phoneNumber,addsdt + numPos + " " + numberAdd + ".");
                            Toast.makeText(MainActivity.this, "Đã gửi, kiểm tra Sms đến sau ít phút", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }else {
                        showAlertDialog("Thông báo","Vui lòng chọn sđt nào để thêm");
                    }
                }
            });
        }

    }

