package com.moviles.loginarchivos.Ui.Registro;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.moviles.loginarchivos.Modelo.Usuario;


import java.io.*;

public class RegistroActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Usuario> mUsuario;
    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }


    public void cargarUsuario(Usuario usuario){


            mUsuario.setValue(usuario);

    }

    public void guardarObjeto(Usuario usuario) {

        File archivo = new File(getApplication().getFilesDir(), "datos.dat");


        try {
            FileOutputStream fos = new FileOutputStream(archivo);//sin true para q se sobreescriba y pueda editar
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(usuario);


            bos.flush();
            fos.close();


            Toast.makeText(getApplication(), "Dato guardado", Toast.LENGTH_LONG).show();


        } catch (FileNotFoundException e) {
            Toast.makeText(getApplication(), "Error al acceder al archivo", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplication(), "Error al acceder al archivo", Toast.LENGTH_LONG).show();
        }
    }



}
