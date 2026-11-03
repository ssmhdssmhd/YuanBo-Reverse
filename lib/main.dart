import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:yuanbo/pages/splash_page.dart';
import 'package:yuanbo/theme/glass_theme.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  // 沉浸式状态栏
  SystemChrome.setSystemUIOverlayStyle(const SystemUiOverlayStyle(
    statusBarColor: Colors.transparent,
    statusBarIconBrightness: Brightness.light,
  ));
  runApp(const YuanBoApp());
}

class YuanBoApp extends StatelessWidget {
  const YuanBoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: '沫兮源播',
      debugShowCheckedModeBanner: false,
      theme: GlassTheme.dark,
      home: const SplashPage(),
      defaultTransition: Transition.cupertino,
    );
  }
}
