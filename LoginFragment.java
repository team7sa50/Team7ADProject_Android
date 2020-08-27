package sg.edu.nus.team7adproject.Home;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import sg.edu.nus.team7adproject.Bean.User;
import sg.edu.nus.team7adproject.HomeActivity;
import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.utils.AsyncToServer;
import sg.edu.nus.team7adproject.utils.Command;


public class LoginFragment extends Fragment implements View.OnClickListener, AsyncToServer.IServerResponse {

    LoginFragment.ILoginFragment iLoginFragment;
    EditText usernameEditText;
    EditText passwordEditText;
    SharedPreferences sessionPref;
    SharedPreferences.Editor sessionPrefEditor;

    public LoginFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button loginButton = (Button) view.findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);
        usernameEditText = (EditText) view.findViewById(R.id.edittext_username);
        passwordEditText = (EditText) view.findViewById(R.id.edittext_password);
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        iLoginFragment = (LoginFragment.ILoginFragment) context;
        iLoginFragment.setFragment("loginFragment", this);
        sessionPref = this.getActivity().getSharedPreferences("session", Context.MODE_PRIVATE);
        sessionPrefEditor = sessionPref.edit();
    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button_login: login(); break;
        }
    }

    private void login(){
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        try{
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Email", username);
            jsonObj.put("Password", password);
            Command cmd = new Command(this, "login","http://10.0.2.2:53299/api/homeapi/login", jsonObj);
            new AsyncToServer().execute(cmd);
        }catch (Exception ex){

        }
    }

    public interface ILoginFragment{
        void sendRequest(JSONObject request);
        void setFragment(String name, Fragment fragment);
        void launchActivity(String userType);
    }

    @Override
    public void onServerResponse(JSONObject jsonObj) {
        if (jsonObj == null)
            return;
        try {
            usernameEditText.getText().clear();
            passwordEditText.getText().clear();
            usernameEditText.requestFocus();
            //
            String context = (String) jsonObj.get("context");
            if (context.equals("login")){
                jsonObj=jsonObj.getJSONObject("result");
                int code = (int)jsonObj.get("code");
                //判断登录结果
                if(code==200){
                    //
                   HomeActivity.loginUser=new User();
                    HomeActivity.loginUser.setId((String)jsonObj.get("id"));
                    HomeActivity.loginUser.setName((String)jsonObj.get("name"));
                    HomeActivity.loginUser.setEmail((String)jsonObj.get("email"));
                    HomeActivity.loginUser.setDepartmentName((String)jsonObj.get("departmentName"));
                    HomeActivity.loginUser.setRole((String)jsonObj.get("role"));
                    sessionPrefEditor.putString("name", (String)jsonObj.get("name"));
                    sessionPrefEditor.commit();
                   // String name = jsonObj.getString("role");
                   // iLoginFragment.launchActivity("home");
                    String name = jsonObj.getString("role");
                    iLoginFragment.launchActivity(jsonObj.getString("role"));
                }
                //提示
                Toast.makeText(getContext(), (String)jsonObj.get("message"), Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
