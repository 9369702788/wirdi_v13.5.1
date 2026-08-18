package com.example.wirdi
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.SharedPreferences
import android.widget.RemoteViews
import es.antonborri.home_widget.HomeWidgetProvider

class WirdiWidgetProvider : HomeWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray, widgetData: SharedPreferences) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.wirdi_widget_layout).apply {
                setTextViewText(R.id.widget_next_prayer_name, widgetData.getString("next_prayer_name", "Next Prayer"))
                setTextViewText(R.id.widget_next_prayer_time, widgetData.getString("next_prayer_time", "--:--"))
                setTextViewText(R.id.widget_hadith_arabic, widgetData.getString("hadith_arabic", "Wirdi"))
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}