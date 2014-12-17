package com.test.organizapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HorariFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HorariFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HorariFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private OnFragmentInteractionListener mListener;

    WebView myWebView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HorariFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HorariFragment newInstance(String param1) {
        HorariFragment fragment = new HorariFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public HorariFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        myWebView = (WebView) getView().findViewById(R.id.webView);

        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new HelloWebViewClient());

        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(true);

        CookieManager.getInstance().setAcceptCookie(true);

        myWebView.loadUrl("https://www.urv.cat/evia/jsp/horaris/selCentre.jsp?cur=2014-15");
        myWebView.loadUrl("https://www.urv.cat/evia/jsp/horaris/selEnsenyaments.jsp?param2=11&param3=Facultat%20de%20Ci%E8ncies%20de%20l%B4Educaci%F3%20i%20Psicologia");

        if (mParam1 != null && !"".equals(mParam1)){

            if (mParam1.equals("op1")){
                myWebView.loadUrl(
                        "https://www.urv.cat/evia/jsp/horaris/selAssignaturesQ.jsp?param1=GRA&param2=Facultat%20de%20Ci%E8ncies%20de%20l%B4Educaci%F3%20i%20Psicologia&param3=1125&param4=Grau%20d%B4Educaci%F3%20Infantil%20(2009)");
            }else if (mParam1.equals("op2")){
                myWebView.loadUrl("https://www.urv.cat/evia/jsp/horaris/selAssignaturesQ.jsp?param1=GRA&param2=Facultat%20de%20Ci%E8ncies%20de%20l%B4Educaci%F3%20i%20Psicologia&param3=1123&param4=Grau%20d%B4Educaci%F3%20Prim%E0ria%20(2009)");
            }else if (mParam1.equals("op3")){
                myWebView.loadUrl("https://www.urv.cat/evia/jsp/horaris/selAssignaturesQ.jsp?param1=GRA&param2=Facultat%20de%20Ci%E8ncies%20de%20l%B4Educaci%F3%20i%20Psicologia&param3=1121&param4=Grau%20de%20Pedagogia%20(2009)");
            }else if (mParam1.equals("op4")){
                myWebView.loadUrl("https://www.urv.cat/evia/jsp/horaris/selAssignaturesQ.jsp?param1=GRA&param2=Facultat%20de%20Ci%E8ncies%20de%20l%B4Educaci%F3%20i%20Psicologia&param3=1122&param4=Grau%20d%B4Educaci%F3%20Social%20(2009)");
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horari, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                       SslError error) {
            handler.proceed();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }


    }

}
