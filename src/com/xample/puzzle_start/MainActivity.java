package com.xample.puzzle_start;


import java.util.Locale;



import com.xample.puzzle_start.R.string;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

@SuppressLint({ "ClickableViewAccessibility", "NewApi", "CutPasteId" })
@SuppressWarnings({ "deprecation", "unused" })
public class MainActivity extends Activity implements OnTouchListener, TextToSpeech.OnInitListener {
	private ImageView image0,image1,image2,image3,image4,image5,image6,image7,image8; // The image that the user drags.
	ImageView img;
	Button btn_show;
	private AbsoluteLayout mainLayout;
	int point=-1;
	private CountDownTimer countDownTimer;
	
	 private boolean timerHasStarted = false;
	
	 
	
	 public TextView text;
	
	 private final long startTime = 0 * 1000;
	
	 private final long interval = 1 * 1000;
	private TextToSpeech TTS;
	ImageView[] box=new ImageView[9];
	ImageView[] downbox=new ImageView[9];	
	ImageView fiximage0,fiximage1,fiximage2,fiximage3,fiximage4,fiximage5,fiximage6,fiximage7,fiximage8;
	int counter;

	ReshapeImage obj = new ReshapeImage();
	Bitmap bmOrginalLion44;
	Bitmap bmOrginalLion88;
	Bitmap bmOrginalLion33;
	Bitmap bmOrginalLion77;
	Bitmap bmOrginalLion22;
	Bitmap bmOrginalLion66;
	Bitmap bmOrginalLion11;
	Bitmap bmOrginalLion55;
	Bitmap bmOrginalLion00;

	Bitmap bmResizedLion44;
	Bitmap bmResizedLion88;
	Bitmap bmResizedLion33;
	Bitmap bmResizedLion77;
	Bitmap bmResizedLion22;
	Bitmap bmResizedLion66;
	Bitmap bmResizedLion11;
	Bitmap bmResizedLion55;
	Bitmap bmResizedLion00;
	Button popup;
	Point p;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img=(ImageView)findViewById(R.id.imageView1);
		 text = (TextView) this.findViewById(R.id.timer);
		 
		   countDownTimer = new MyCountDownTimer(startTime, interval);
		 
		   text.setText(text.getText() + String.valueOf(startTime / 1000));
		TTS = new TextToSpeech(this, this);
		fiximage0=(ImageView)findViewById(R.id.fiximage0);
		fiximage1=(ImageView)findViewById(R.id.fiximage1);
		fiximage2=(ImageView)findViewById(R.id.fiximage2);
		fiximage3=(ImageView)findViewById(R.id.fiximage3);
		fiximage4=(ImageView)findViewById(R.id.fiximage4);
		fiximage5=(ImageView)findViewById(R.id.fiximage5);
		fiximage6=(ImageView)findViewById(R.id.fiximage6);
		fiximage7=(ImageView)findViewById(R.id.fiximage7);
		fiximage8=(ImageView)findViewById(R.id.fiximage8);
		btn_show = (Button) findViewById(R.id.popup);
		mainLayout = (AbsoluteLayout) findViewById(R.id.container);
		btn_show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (!timerHasStarted) {
					
					   countDownTimer.start();
					
					   timerHasStarted = true;
					
					   btn_show.setText("STOP");
					
					  } else {
					
					   countDownTimer.cancel();
					
					   timerHasStarted = false;
					
					   btn_show.setText("RESTART");
					
					  }
				solve();
				
				
			}

			


		});

		Bitmap bmOrginalLion4=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_4);
		Bitmap bmOrginalLion8=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_8);
		Bitmap bmOrginalLion3=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_3);
		Bitmap bmOrginalLion7=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_7);
		Bitmap bmOrginalLion2=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_2);
		Bitmap bmOrginalLion6=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_6);
		Bitmap bmOrginalLion1=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_1);
		Bitmap bmOrginalLion5=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_5);
		Bitmap bmOrginalLion0=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_0);

		Bitmap bmResizedLion4=obj.getResizedBitmap(bmOrginalLion4,100,100);
		Bitmap bmResizedLion8=obj.getResizedBitmap(bmOrginalLion8,100,100);
		Bitmap bmResizedLion3=obj.getResizedBitmap(bmOrginalLion3,100,100);
		Bitmap bmResizedLion7=obj.getResizedBitmap(bmOrginalLion7,100,100);
		Bitmap bmResizedLion2=obj.getResizedBitmap(bmOrginalLion2,100,100);
		Bitmap bmResizedLion6=obj.getResizedBitmap(bmOrginalLion6,100,100);
		Bitmap bmResizedLion1=obj.getResizedBitmap(bmOrginalLion1,100,100);
		Bitmap bmResizedLion5=obj.getResizedBitmap(bmOrginalLion5,100,100);
		Bitmap bmResizedLion0=obj.getResizedBitmap(bmOrginalLion0,100,100);




		image0 = (ImageView)findViewById(R.id.image0);
		image1 = (ImageView)findViewById(R.id.image1);
		image2 = (ImageView)findViewById(R.id.image2);
		image3 = (ImageView)findViewById(R.id.image3);
		image4 = (ImageView)findViewById(R.id.image4);
		image5 = (ImageView)findViewById(R.id.image5);
		image6 = (ImageView)findViewById(R.id.image6);
		image7 = (ImageView)findViewById(R.id.image7);
		image8 = (ImageView)findViewById(R.id.image8);

		//image0.setImageResource(R.drawable.pic4);
		image0.setImageBitmap(bmResizedLion4);
		//image1.setImageResource(R.drawable.pic8);
		image1.setImageBitmap(bmResizedLion8);
		//image2.setImageResource(R.drawable.pic3);
		image2.setImageBitmap(bmResizedLion3);
		//image3.setImageResource(R.drawable.pic7);
		image3.setImageBitmap(bmResizedLion7);
		//image4.setImageResource(R.drawable.pic2);
		image4.setImageBitmap(bmResizedLion2);
		//image5.setImageResource(R.drawable.pic6);
		image5.setImageBitmap(bmResizedLion6);
		//image6.setImageResource(R.drawable.pic1);
		image6.setImageBitmap(bmResizedLion1);
		//image7.setImageResource(R.drawable.pic5);
		image7.setImageBitmap(bmResizedLion5);
		//image8.setImageResource(R.drawable.pic0);
		image8.setImageBitmap(bmResizedLion0);
		//image1.setImageResource(R.drawable.pic8);


		mainLayout.setOnTouchListener(this);
		image0.setOnTouchListener(this);
		image1.setOnTouchListener(this);
		image2.setOnTouchListener(this);
		image3.setOnTouchListener(this);
		image4.setOnTouchListener(this);
		image5.setOnTouchListener(this);
		image6.setOnTouchListener(this);
		image7.setOnTouchListener(this);
		image8.setOnTouchListener(this);

		downbox[0] = (ImageView) findViewById(R.id.downbox0);
		downbox[1] = (ImageView) findViewById(R.id.downbox1);
		downbox[2] = (ImageView) findViewById(R.id.downbox2);
		downbox[3] = (ImageView) findViewById(R.id.downbox3);
		downbox[4] = (ImageView) findViewById(R.id.downbox4);
		downbox[5] = (ImageView) findViewById(R.id.downbox5);
		downbox[6] = (ImageView) findViewById(R.id.downbox6);
		downbox[7] = (ImageView) findViewById(R.id.downbox7);
		downbox[8] = (ImageView) findViewById(R.id.downbox8);


		box[0] = (ImageView) findViewById(R.id.box0);
		box[1] = (ImageView) findViewById(R.id.box1);
		box[2] = (ImageView) findViewById(R.id.box2);
		box[3] = (ImageView) findViewById(R.id.box3);
		box[4] = (ImageView) findViewById(R.id.box4);
		box[5] = (ImageView) findViewById(R.id.box5);
		box[6] = (ImageView) findViewById(R.id.box6);
		box[7] = (ImageView) findViewById(R.id.box7);
		box[8] = (ImageView) findViewById(R.id.box8);

		bmOrginalLion44=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_4);
		bmOrginalLion88=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_8);
		bmOrginalLion33=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_3);
		bmOrginalLion77=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_7);
		bmOrginalLion22=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_2);
		bmOrginalLion66=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_6);
		bmOrginalLion11=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_1);
		bmOrginalLion55=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_5);
		bmOrginalLion00=BitmapFactory.decodeResource(this.getResources(), R.drawable.lion_0);

		bmResizedLion44=obj.getResizedBitmap(bmOrginalLion44,130,130);
		bmResizedLion88=obj.getResizedBitmap(bmOrginalLion88,130,130);
		bmResizedLion33=obj.getResizedBitmap(bmOrginalLion33,130,130);
		bmResizedLion77=obj.getResizedBitmap(bmOrginalLion77,130,130);
		bmResizedLion22=obj.getResizedBitmap(bmOrginalLion22,130,130);
		bmResizedLion66=obj.getResizedBitmap(bmOrginalLion66,130,130);
		bmResizedLion11=obj.getResizedBitmap(bmOrginalLion11,130,130);
		bmResizedLion55=obj.getResizedBitmap(bmOrginalLion55,130,130);
		bmResizedLion00=obj.getResizedBitmap(bmOrginalLion00,130,130);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}




	}
	public class MyCountDownTimer extends CountDownTimer {
		
		  public MyCountDownTimer(long startTime, long interval) {
		
		   super(startTime, interval);
		
		  }
		
		 
		
		  @Override
		
		  public void onFinish() {
		
		   text.setText("Time's up!");
		
		  }
		
		 
		
		  @Override
		
		  public void onTick(long millisUntilFinished) {
		
		   text.setText("" + millisUntilFinished / 1000);
		
		  }
		
		 }

	private void solve() {
		// TODO Auto-generated method stub
		Bitmap[] parts = new Bitmap[9];
		parts[0]=bmResizedLion00;
		parts[1]=bmResizedLion11;
		parts[2]=bmResizedLion22;
		parts[3]=bmResizedLion33;
		parts[4]=bmResizedLion44;
		parts[5]=bmResizedLion55;
		parts[6]=bmResizedLion66;
		parts[7]=bmResizedLion77;
		parts[8]=bmResizedLion88;
//		Bitmap result = Bitmap.createBitmap(parts[0].getWidth() * 3, parts[0].getHeight() * 3, Bitmap.Config.ARGB_8888);
//		Canvas canvas = new Canvas(result);
//		Paint paint = new Paint();
//		for (int i = 0; i < parts.length; i++) {
//			canvas.drawBitmap(parts[i], parts[i].getWidth() * (i % 3), parts[i].getHeight() * (i / 3), paint);
//		}
		image0.setImageDrawable(null);
		image1.setImageDrawable(null);
		image2.setImageDrawable(null);
		image3.setImageDrawable(null);
		image4.setImageDrawable(null);
		image5.setImageDrawable(null);
		image6.setImageDrawable(null);
		image7.setImageDrawable(null);
		image8.setImageDrawable(null);
		
		fiximage0.setImageBitmap(parts[0]);
		fiximage1.setImageBitmap(parts[1]);
		fiximage2.setImageBitmap(parts[2]);
		fiximage3.setImageBitmap(parts[3]);
		fiximage4.setImageBitmap(parts[4]);
		fiximage5.setImageBitmap(parts[5]);
		fiximage6.setImageBitmap(parts[6]);
		fiximage7.setImageBitmap(parts[7]);
		fiximage8.setImageBitmap(parts[8]);
//		new CountDownTimer(5000,1000){
//	        @Override
//	        public void onTick(long millisUntilFinished){} 
//
//	        @Override
//	        public void onFinish(){
//	               //set the new Content of your activity
//	        	MainActivity.this.setContentView(R.layout.activity_main);
//	        }
//	   }.start();
	}

	private boolean dragging = false;
	private Rect hitRect = new Rect();

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		counter=0;



		boolean eventConsumed = true;
		int x = (int)event.getX();
		int y = (int)event.getY();
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {

			if (v == image0) {
				point=0;
				System.out.println(" image 0000000000 is clicked");
				//image0.setImageResource(R.drawable.pic4);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image1){
				point=1;
				System.out.println(" image 1111111111 is clicked");

				//image1.setImageResource(R.drawable.pic8);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image2){
				point=2;
				System.out.println(" image 2222222222 is clicked");

				//image2.setImageResource(R.drawable.pic3);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image3){
				point=3;
				System.out.println(" image 3333333333 is clicked");

				//image3.setImageResource(R.drawable.pic7);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image4){
				point=4;
				System.out.println(" image 4444444444 is clicked");

				//image4.setImageResource(R.drawable.pic2);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image5){
				point=5;
				System.out.println(" image 5555555555 is clicked");

				//image5.setImageResource(R.drawable.pic6);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image6){
				point=6;
				System.out.println(" image 6666666666 is clicked");

				//image6.setImageResource(R.drawable.pic1);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image7){
				point=7;
				System.out.println(" image 7777777777 is clicked");
				//image7.setImageResource(R.drawable.pic5);
				dragging = true;
				eventConsumed = false;
			}
			if (v == image8){
				point=8;
				System.out.println(" image 8888888888 is clicked");
				//image8.setImageResource(R.drawable.pic0);
				dragging = true;
				eventConsumed = false;
			}
		} else if (action == MotionEvent.ACTION_UP) {
			if (dragging) {
				startnewactivity();
				for(int i=0;i<=8;i++)
				{
					box[i].getHitRect(hitRect);

					if (hitRect.contains(x, y)) 
					{
						if(point==0){
							if(point==0 && i==4)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//									fiximage4.setImageResource(R.drawable.pic4);
									//									fiximage4.setScaleType(ScaleType.MATRIX);
									fiximage4.setImageBitmap(bmResizedLion44);

									image0.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image0, box[i]);
							}else
							{

								System.out.println("voice command");
								speakout();
							}
						}
						if(point==1)
						{
							if(point==1 && i==8)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage8.setImageResource(R.drawable.pic8);
									fiximage8.setImageBitmap(bmResizedLion88);

									image1.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image1, box[i]);
							}
							else{
								System.out.println("voice command");
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

							}
						}

						if(point==2){
							if(point==2 && i==3)
							{
								if(box[i].getDrawable() == null)
								{
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage3.setImageResource(R.drawable.pic3);
									fiximage3.setImageBitmap(bmResizedLion33);

									image2.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image2, box[i]);
							}
							else{
								System.out.println("voice command");
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

							}
						}
						if(point==3){
							if(point==3 && i==7)
							{
								if(box[i].getDrawable() == null)
								{
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage7.setImageResource(R.drawable.pic7);
									fiximage7.setImageBitmap(bmResizedLion77);

									image3.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image3, box[i]);
							}
							else{
								System.out.println("voice command");
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

							}
						}
						if(point==4){
							if(point==4 && i==2)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage2.setImageResource(R.drawable.pic2);
									fiximage2.setImageBitmap(bmResizedLion22);

									image4.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image4, box[i]);
							}
							else
							{
								System.out.println("voice command");
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

							}
						}
						if(point==5){
							if(point==5 && i==6)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage6.setImageResource(R.drawable.pic6);
									fiximage6.setImageBitmap(bmResizedLion66);

									image5.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image5, box[i]);
							}
							else
							{
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

								System.out.println("voice command");
							}
						}
						if(point==6){
							if(point==6 && i==1)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage1.setImageResource(R.drawable.pic1);
									fiximage1.setImageBitmap(bmResizedLion11);

									image6.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image6, box[i]);
							}
							else{
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

								System.out.println("voice command");
							}
						}
						if(point==7){
							if(point==7 && i==5)
							{

								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage5.setImageResource(R.drawable.pic5);
									fiximage5.setImageBitmap(bmResizedLion55);

									image7.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image7, box[i]);
							}
							else{
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

								System.out.println("voice command");
							}
						}
						if(point==8){
							if(point==8 && i==0)
							{
								if(box[i].getDrawable() == null){
									TTS.speak("Good work", TextToSpeech.QUEUE_FLUSH, null);

									//fiximage0.setImageResource(R.drawable.pic0);
									fiximage0.setImageBitmap(bmResizedLion00);

									image8.setImageDrawable(null);
								}
								//setSameAbsoluteLocation(image8, box[i]);
							}
							else{
								System.out.println("voice command");
								TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);

							}
						}
					}	
					else {
						counter=counter+1;
					}
					if(counter==9)
					{
						System.out.println("Enter voice command");	
						speakout1();

					}

				}
				for(int i=0;i<=8;i++)
				{
					//					downbox[i].getHitRect(hitRect);
					//					if (hitRect.contains(x, y)) {
					//						if(point==0){
					//							//image0.setImageResource(R.drawable.flower);
					//							setSameAbsoluteLocation(image0, downbox[i]);
					//						}if(point==1){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image1, downbox[i]);
					//						}if(point==2){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image2, downbox[i]);
					//						}if(point==3){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image3, downbox[i]);
					//						}if(point==4){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image4, downbox[i]);
					//						}if(point==5){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image5, downbox[i]);
					//						}if(point==6){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image6, downbox[i]);
					//						}if(point==7){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image7, downbox[i]);
					//						}if(point==8){
					//							//image1.setImageResource(R.drawable.unnamed);
					//							setSameAbsoluteLocation(image8, downbox[i]);
					//						}
					//					}
				}
			}

			dragging = false;
			eventConsumed = false;

		} else if (action == MotionEvent.ACTION_MOVE) {
			//						if (v != image0 && point == 0 ) {
			//							if (dragging) {
			//								//System.out.println("adfhafbafbafjbj");
			//								//setAbsoluteLocationCentered(image0, x, y);
			//							}
			//			
			//						}
			//						if (v != image1 && point == 1) {
			//							if (dragging) {
			//								//setAbsoluteLocationCentered(image1, x, y);
			//							}
			//						}
		}
		else if (action == MotionEvent.ACTION_CANCEL) {

			System.out.println("adfhafbafbafjbj");
		}
		return eventConsumed;
	}
	private void startnewactivity() {
		// TODO Auto-generated method stub
		if(fiximage0!=null && fiximage1!=null && fiximage2!=null && fiximage3!=null && fiximage4!=null && fiximage5!=null){
			if(fiximage6!=null && fiximage7!=null && fiximage8!=null){
				System.out.println("Say hello to next activity");
			}
		}
	}

	private void speakout1() {
		// TODO Auto-generated method stub
		TTS.speak("wrong position", TextToSpeech.QUEUE_FLUSH, null);

	}

	private void speakout() {
		// TODO Auto-generated method stub
		TTS.speak("Place the image to right cell", TextToSpeech.QUEUE_FLUSH, null);
	}

	private void setSameAbsoluteLocation(View image, View box) {

		AbsoluteLayout.LayoutParams alp2 = (AbsoluteLayout.LayoutParams) box.getLayoutParams();
		setAbsoluteLocationfortheimageandbox(image, alp2.x, alp2.y);

	}
	private void setAbsoluteLocationfortheimageandbox(View image, int x, int y) {
		AbsoluteLayout.LayoutParams alp = (AbsoluteLayout.LayoutParams) image.getLayoutParams();
		alp.x = x;
		alp.y = y;
		image.setX(alp.x);
		image.setY(alp.y);
	}

	private void setAbsoluteLocationCentered(View image, int x, int y) {
		setAbsoluteLocation(image, x - image.getWidth() / 2, y - image.getHeight() / 2);

	}
	private void setAbsoluteLocation(View image, int x, int y) {
		AbsoluteLayout.LayoutParams alp = (AbsoluteLayout.LayoutParams) image.getLayoutParams();
		alp.x = x;
		alp.y = y;
		image.setX(alp.x);
		image.setY(alp.y);
		//image.setLayoutParams(alp);
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus){
		int w=image0.getWidth();
		int h=image0.getHeight();
		System.out.println("Height="+w+"Width"+h);
		int[] location = new int[2];

	}

	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (TTS != null) {
			TTS.stop();
			TTS.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {


		if (status == TextToSpeech.SUCCESS) {

			int result = TTS.setLanguage(Locale.US);

			TTS.setPitch(1); // set pitch level

			TTS.setSpeechRate(-5); // set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
				//	btnSpeak.setEnabled(true);
				//speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}

	}

}
