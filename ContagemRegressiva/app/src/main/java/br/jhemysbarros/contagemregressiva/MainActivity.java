package br.jhemysbarros.contagemregressiva;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText timerEditText;
    TextView startButton;

    boolean paused = false;
    Object pauseLock = new Object();
    boolean finished = false;
    int state = 0;
    int countdownNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerEditText = (EditText) findViewById(R.id.tv_contagem);
        startButton = (TextView) findViewById(R.id.btn_start);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public synchronized void onClick(View view) {

                countdownNumber = Integer.parseInt(timerEditText.getText().toString());

                switch (state) {
                    case 0:
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                finished = false;
                                while (!finished) {
                                    for (int i = countdownNumber; i >= 0; i--) {

                                        synchronized (pauseLock) {
                                            while (paused) {
                                                try {
                                                    pauseLock.wait();
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }

                                        // A linha abaixo lança uma excepção. Não poderá interagir com o
                                        // UI thread trabalhando com uma thread
                                        /* timerTextView.setText(String.valueOf(i)); */

                                        // Obter uma mensagem do conjunto global de mensagens
                                        Message msg = timerHandler.obtainMessage();

                                        // Atribuir um valor à variável 'what'. Poderia também ter usado
                                        // sobrecarga do método obtainMessage(int what)
                                        msg.what = i;

                                        // Enviando mensagem para o handler
                                        timerHandler.sendMessage(msg);

                                        Log.d("Valor do temporizador de thread", String.valueOf(i));

                                        try {
                                            // Sleep por 1 segundo
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        };
                        // Iniciar a thread
                        thread.start();
                        startButton.setText(R.string.pousar_contagem);
                        state = 1;
                        break;
                    case 1:
                        synchronized (pauseLock) {
                            paused = true;
                            state = 2;
                            Log.d("estado:", "paused");
                            startButton.setText(R.string.resume_contagem);
                        }
                        break;
                    case 2:
                        synchronized (pauseLock) {
                            paused = false;
                            pauseLock.notifyAll();
                            Log.d("estado:", "resumed");
                            startButton.setText(R.string.pousar_contagem);
                            state = 1;
                        }
                        break;
                }
            }

            // Handler que receberá e processará mensagens na interface do usuário
            final Handler timerHandler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message message) {

                    // Obter a mensagem e atualizar a janela do texto.
                    timerEditText.setText(String.valueOf(message.what));
                    if (message.what <= 0) {
                        startButton.setText(R.string.iniciar_contagem);
                        finished = true;
                        state = 0;
                        Log.d("estado:", "Start");
                    }
                    return false;
                }
            }
            );
        });
    }
}