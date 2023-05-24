package com.example.govnozalypa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.govnozalypa.ui.theme.GovnozalypaTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GovnozalypaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Login()

                   }
                }
            }
        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable

fun Login() {


    var username by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop
            )
        
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .alpha(0.6f)
            .clip(
                CutCornerShape(
                    topStart = 8.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 8.dp
                )
            )
            .background(MaterialTheme.colors.background)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            LoginFields(username,password, onPasswordChange = {
                password = it
            },
            onUsernameChange = {
                username = it
            })
            LoginFooter()
        }
    }
}

@Composable
fun LoginHeader() {
    Text(text = "Добро пожаловать!", fontSize = 31.sp, fontWeight = FontWeight.ExtraBold)
    Text(text = "Войдите чтобы продолжить",
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold
        )
}


@Composable
fun LoginFields(username:String,
                password: String,
                onUsernameChange:(String) -> Unit, onPasswordChange: (String) -> Unit) {
    DiplomField(value = username,
        label = "Username" ,
        placeholder = "Введите email адрес",
        onValueChange = onUsernameChange,
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = "Email")
        }
        )
    
    Spacer(modifier = Modifier.height(8.dp))
    
    DiplomField(value = password,
        label = "Password",
        placeholder = "Введите пароль",
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "Password")
        }
    )
}

@Composable
fun LoginFooter() {
    
}

@Composable
fun DiplomField(value: String,
              label: String,
              placeholder: String,
              visualTransformation:VisualTransformation = VisualTransformation.None,
              keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
              leadingIcon: @Composable (() -> Unit)? = null,
              trailingIcon: @Composable (() -> Unit)? = null,
              onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
                },
        placeholder = {
            Text(text = placeholder)
                      },
    VisualTransformation = VisualTransformation,
    KeyboardOptions = KeyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )

}