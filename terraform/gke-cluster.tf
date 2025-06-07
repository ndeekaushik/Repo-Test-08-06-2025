
variable "cluster_name" {
  description = "The name of the GKE cluster"
  type        = string
  default     = "example-gke-cluster"
}

variable "node_count" {
  description = "The number of nodes in the default node pool"
  type        = number
  default     = 3
}

variable "machine_type" {
  description = "The machine type for the nodes"
  type        = string
  default     = "e2-medium"
}

# Variables for configuration
variable "project_id" {
  description = "The GCP project ID"
  type        = string
  default     = "defaultproject-gcp"
}

variable "region" {
  description = "The GCP region"
  default     = "us-central1"
  type        = string
}

variable "credentials_file" {
  description = "Path to the service account key file"
  type        = string
  default     = "us-central1"
}

# Create GKE cluster without default node pool
resource "google_container_cluster" "primary" {
  name                      = var.cluster_name
  location                  = var.region
  remove_default_node_pool  = true
  initial_node_count        = 1
  deletion_protection       = false
}

# Create custom node pool
resource "google_container_node_pool" "primary_nodes" {
  name       = "${var.cluster_name}-node-pool"
  cluster    = var.cluster_name
  location   = var.region
  node_count = var.node_count

  node_config {
    machine_type = var.machine_type
    disk_size_gb = 10
  }
  # Explicit dependency
  depends_on = [google_container_cluster.primary]
}

# Output the cluster name and endpoint
output "cluster_name" {
  description = "The name of the GKE cluster"
  value       = google_container_cluster.primary.name
}

output "endpoint" {
  description = "The endpoint of the GKE cluster"
  value       = google_container_cluster.primary.endpoint
}
