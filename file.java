 AlertDialog.Builder builderSingle = new AlertDialog.Builder(ClaimActivity.this);
            builderSingle.setCancelable(false);
            TextView textView = new TextView(this);
            textView.setText("Select a Product");
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0, 25, 0, 0);
            textView.setTextSize(16);
            builderSingle.setCustomTitle(textView);
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ClaimActivity.this, R.layout.camlife_alert_dialog_singlechoice, R.id.text1);
            productOffline = new ArrayList<>();
            productOnline = new ArrayList<>();
            StringBuffer productOfflineBuffer = new StringBuffer();
            StringBuffer productOnlineBuffer = new StringBuffer();


            for (int i = 0; i < productsResponse.getData().size(); i++) {
                boolean isOfline = productsResponse.getData().get(i).getIsOnline();
                if (isOfline == false) {
                    productOffline.add(productsResponse.getData().get(i).getName());

                } else {
                    productOnline.add(productsResponse.getData().get(i).getName());
                }
                whatisOffline = 1;


            }


            for (int j = 0; j < productOffline.size(); j++) {
                if (j == productOffline.size() - 1) {
                    productOfflineBuffer.append(productOffline.get(j));
                } else {
                    productOfflineBuffer.append(productOffline.get(j) + " orr ");
                }
                whatisOnline = 2;
            }
            String offline = productOfflineBuffer.toString();


            for (int k = 0; k < productOnline.size(); k++) {
                if (k == productOnline.size() - 1) {
                    productOnlineBuffer.append(productOnline.get(k));
                } else {
                    productOnlineBuffer.append(productOnline.get(k) + " or ");
                }

            }
            String online = productOnlineBuffer.toString();

            arrayAdapter.add(online);
            arrayAdapter.add(offline);

            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String strName = arrayAdapter.getItem(which);
                    AlertDialog.Builder builderInner = new AlertDialog.Builder(ClaimActivity.this);
                    mSelectProductEditText.setText(strName);
                    if (strName.equals(online)) {
                        CustomizeIntent mSimpleLife = new CustomizeIntent(ClaimActivity.this);
                        mSimpleLife.startIntent(ClaimSimpleLifeActivity.class);

                    } else {
                        CustomizeIntent mSimpleLife = new CustomizeIntent(ClaimActivity.this);
                        mSimpleLife.startIntent(ClaimProcessesGroupActivity.class);
                    }

                }
            });
            builderSingle.show();

        }
