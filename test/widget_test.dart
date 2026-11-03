import 'package:flutter_test/flutter_test.dart';
import 'package:yuanbo/main.dart';

void main() {
  testWidgets('App smoke test', (WidgetTester tester) async {
    await tester.pumpWidget(const YuanBoApp());
    expect(find.byType(YuanBoApp), findsOneWidget);
  });
}
