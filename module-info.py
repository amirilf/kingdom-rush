import os

# Define the module name and the base directory for your packages
module_name = "app.game"
base_directory = "src/main/java/app/game"


def find_subpackages(base_dir, parent_package):
    subpackages = []
    for root, dirs, files in os.walk(base_dir):
        for d in dirs:
            package = os.path.relpath(os.path.join(root, d), base_dir).replace(
                os.sep, "."
            )
            subpackages.append(f"{parent_package}.{package}")
    return subpackages


def generate_module_info(module_name, subpackages):
    lines = [
        f"module {module_name} {{",
        "    requires transitive javafx.graphics;",
        "    requires javafx.controls;",
        "    requires javafx.fxml;",
        "",
        f"    opens {module_name} to javafx.fxml;",
        "",
        f"    exports {module_name};",
        "",
    ]

    for subpackage in subpackages:
        lines.append(f"    opens {subpackage} to javafx.fxml;")
        lines.append(f"    exports {subpackage};")
        lines.append("")

    lines.append("}")

    with open("src/main/java/module-info.java", "w") as f:
        f.write("\n".join(lines))


subpackages = find_subpackages(base_directory, module_name)
generate_module_info(module_name, subpackages)
