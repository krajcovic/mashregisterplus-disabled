package cz.monetplus.mashregisterplus.ingenico;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import cz.monetplus.blueterm.PosCallbacks;

public class PosCallbackee implements PosCallbacks {

	private static final String TAG = "PosCallbackee";
	
	/**
	 * 
	 */
	private Activity activity;
	
	/**
	 * 
	 */
	private Context context;

	/**
	 * 
	 */
	private Boolean isSignOk;

	/**
	 * 
	 */
	private List<String> ticket = new ArrayList<String>();
	
	/**
	 * @param activity
	 * @param context
	 */
	public PosCallbackee(Activity activity, Context context) {
		this.activity = activity;
		this.context = context;
	}

	@Override
	public Boolean ticketLine(final String line) {
		getTicket().add(line);
		
		return Boolean.TRUE;
	}
	
	@Override
	public void ticketFinish() {
		// Ukonci listek		
	}
	
	@Override
	public void progress(final String line) {

	}

	public void progressToast(final String line) {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				Toast.makeText(context, line, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public Boolean isSingOk() {
		// TODO Auto-generated method

//		synchronized (isSignOk) {
//			Runnable runnable = new Runnable() {
//
//				final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						switch (which) {
//						case DialogInterface.BUTTON_POSITIVE:
//							// Yes button clicked
//							isSignOk = Boolean.TRUE;
//							break;
//
//						case DialogInterface.BUTTON_NEGATIVE:
//							isSignOk = Boolean.TRUE;
//							break;
//						}
//						this.notify();
//					}
//				};
//
//				public void run() {
//					AlertDialog.Builder builder = new AlertDialog.Builder(
//							activity);
//					builder.setMessage("Souhlasí podpis?")
//							.setPositiveButton("Ano", dialogClickListener)
//							.setNegativeButton("Ne", dialogClickListener)
//							.show();
//				}
//			};
//
//			activity.runOnUiThread(runnable);
//
//			try {
//				runnable.wait();
//			} catch (InterruptedException e) {
//				Log.e(TAG, e.getMessage());
//			}
//
//		}

		return Boolean.TRUE;
	}

	@Override
	public Boolean isConnectivity() {
		// TODO: zkontroluj ze su online.

		return Boolean.TRUE;
	}

	public List<String> getTicket() {
		return ticket;
	}

	public void setTicket(List<String> ticket) {
		this.ticket = ticket;
	}
}