package com.example.android.userinfocall2;

import com.example.android.userinfocall2.entities.User;
import java.util.ArrayList;

public interface UsersContract {

    interface View {
        void showErrorMessage(String error);

        void showUserData(ArrayList<User>listInfo);
    }

    interface Presenter {
        void populateUserList();
    }

}
