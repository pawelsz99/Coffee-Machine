// write the classes here

class OperatingSystem(var name: String = "default")

class DualBoot(var primaryOs: OperatingSystem = OperatingSystem("Win"),
               var secondaryOs: OperatingSystem = OperatingSystem("Linux"))